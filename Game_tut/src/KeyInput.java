import java.awt.MouseInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private ObjectHandler gHandler;
	private ResourceHandler resHand = null;
	private GlobalEvents gEvent;
	
	KeyInput(ObjectHandler handler, ResourceHandler resHand, GlobalEvents eve){
		gHandler = handler;
		this.resHand = resHand;
		this.gEvent = eve;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		System.out.print(key);
		
		if (key == KeyEvent.VK_W)	gHandler.players.getFirst().setVelY(-1.0f);
		if (key == KeyEvent.VK_S)	gHandler.players.getFirst().setVelY(1.0f);
		if (key == KeyEvent.VK_A)	gHandler.players.getFirst().setVelX(-1.0f);
		if (key == KeyEvent.VK_D)	gHandler.players.getFirst().setVelX(1.0f);
		
		
		if (key == KeyEvent.VK_1) { 
			if (resHand.CanBuild(resHand.costIndex.wall)) {
				resHand.currStructure = resHand.costIndex.wall;
			}
		}
		if (key == KeyEvent.VK_2) { 
			if (resHand.CanBuild(resHand.costIndex.house)) {
				resHand.currStructure = resHand.costIndex.house;
			}
		}

		if (key == KeyEvent.VK_ESCAPE) {
			gEvent.currEvent = GLOBALEVENTTYPES.EndGame;
			
		}
	}
	
	public void keyReleased(KeyEvent e) {
int key = e.getKeyCode();
		
		System.out.print(key);
		
		if (key == KeyEvent.VK_W)	gHandler.players.getFirst().setVelY(0.0f);
		if (key == KeyEvent.VK_S)	gHandler.players.getFirst().setVelY(0.0f);
		if (key == KeyEvent.VK_A)	gHandler.players.getFirst().setVelX(0.0f);
		if (key == KeyEvent.VK_D)	gHandler.players.getFirst().setVelX(0.0f);
	}
	
}
