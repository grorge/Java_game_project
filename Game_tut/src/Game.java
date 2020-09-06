import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

	GlobalEvents gEvent;
	
	static int WIN_WIDTH = 1024;
	static int WIN_HEIGTH = 1024;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7541542548355040915L;

	
	private Thread t_gameThread;
	private boolean running = false;

	// Timer
	private long last_tick;
	private float tickSize = 3000000.0f;
	private float deltaTick = 0.0f;
//	private int frames = 0;
	

	// Handler for objects
	private ObjectHandler hand;
	private MapLoader mapHand;

	private ResourceHandler resHandler;	
	
	private g_Window gWin;
	
	public Game() {

		this.gEvent = new GlobalEvents();
		
		hand = new ObjectHandler(gEvent);
		

		mapHand = new MapLoader(); 
		mapHand.loadMap(new MapDataHome());
		hand.addMapObjects(mapHand.mapObjects);
		
		
		resHandler = new ResourceHandler();

		resHandler.AddResource(RESOURCETYPE.STONE, 1500);
		resHandler.AddResource(RESOURCETYPE.WOOD, 1300);
		
		this.addKeyListener(new KeyInput(hand, resHandler, gEvent));
		this.addMouseListener(new MouseInput(hand, resHandler));
		
		gWin = new g_Window(WIN_WIDTH,WIN_HEIGTH,"GAME TUT", this);
		
	}
	
	
	public synchronized void start()
	{
		t_gameThread = new Thread(this);
		t_gameThread.start();
		
		running = true;
		
		last_tick = System.nanoTime();
		
		
	}

	public void run() {

		while(running) {
			long tickNow = System.nanoTime();
			
			deltaTick += tickNow - last_tick;

//			System.out.println("L:" + lastTick + " N:" + tickNow + " D:" + deltaTick);

			if (deltaTick > tickSize) {
				last_tick = tickNow;
				deltaTick = 0.0f;
				
				tick();
//				frames++;
//				System.out.println("F:" + frames);
				
			}
			render();
			
			if (gEvent.currEvent == GLOBALEVENTTYPES.EndGame) {
				this.stop();
			}
			
		}
		
	}

	public void stop() {
		System.out.print("Stoping thread");
		try {
			t_gameThread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/////////////////////////
	/////////////////////////
	/////////////////////////
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//Clear
		g.setColor(Color.green);
		g.fillRect(0, 0, WIN_WIDTH, WIN_HEIGTH-60);
		
		
		//Draw objects
		mapHand.render(g);
		hand.render(g);
		resHandler.render(g);
		
		g.dispose(); 
		bs.show();
	}
	
	
	
	private void tick() {
		hand.tick();

		
		InterperateEvent();
	}
	
	private void InterperateEvent() {
		if (gEvent.currEvent == GLOBALEVENTTYPES.LoadMap) {

			System.out.println("Trying to load:" + gEvent.msg + ":");
			if (gEvent.msg.compareTo("house") == 0) {	
				this.ChangeMap(new MapDataHouse());					
			}
			else if (gEvent.msg.compareTo("home") == 0) {
				this.ChangeMap(new MapDataHome());			
			}
			
			
		}
		
		gEvent.clear();
	}

	private void ChangeMap(MapData newMap) {
		mapHand.loadMap(newMap);
		hand.addMapObjects(mapHand.mapObjects);	
	}
	///////////////////////
	///////////////////////
	///////////////////////
	
	public static void main(String args[]) {
		
		
		new Game();
	}
}
