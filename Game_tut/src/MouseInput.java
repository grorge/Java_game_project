import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private ObjectHandler hand = null;	
	public ResourceHandler resHand = null;
	
	public MouseInput(ObjectHandler hand, ResourceHandler resHand){
		
		this.hand = hand;
		this.resHand = resHand;
	}
	
	public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        System.out.println(mx + "," + my);
	    
        if (resHand.CanBuild(resHand.currStructure)) {
        	
        	resHand.SpendResource(RESOURCETYPE.WOOD, resHand.currStructure.wood);
        	resHand.SpendResource(RESOURCETYPE.STONE, resHand.currStructure.stone);
			
        	hand.addObj(new ObjTerrain(mx, my, 32,32));
		}
    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
}
