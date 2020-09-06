import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

public class ResourceHandler {
	int playerId = 0;
	HashMap<RESOURCETYPE, Resource> playerResourses = new HashMap<RESOURCETYPE, Resource>();
	
	public StructureIndex costIndex;
	public StructureInfo currStructure; 

	ResourceHandler() {

		playerResourses.put(RESOURCETYPE.WOOD, new Resource(RESOURCETYPE.WOOD));
		playerResourses.put(RESOURCETYPE.STONE, new Resource(RESOURCETYPE.STONE));
		
		costIndex = new StructureIndex();
		
		this.currStructure = costIndex.wall;
	}

	int GetResourse(RESOURCETYPE type) {
		return playerResourses.get(type).amount;
	}
	void AddResource(RESOURCETYPE type, int new_resource) {
		playerResourses.get(type).amount += new_resource;
	}

	// Returns false if not enough resource
	boolean SpendResource(RESOURCETYPE type, int resource_cost) {
		if (playerResourses.get(type).amount >= resource_cost) {
			playerResourses.get(type).amount -= resource_cost;
			
			return true;
		}
		else {
			System.out.println("Out of resource");
			return false;
		}
	}
	
	boolean CanBuild(StructureInfo cost) {
		if (cost.wood <= this.playerResourses.get(RESOURCETYPE.WOOD).amount
				&&
				cost.stone <= this.playerResourses.get(RESOURCETYPE.STONE).amount) {
			return true;
		}
		else {
			System.out.println("Not enough resource s:" + this.playerResourses.get(RESOURCETYPE.STONE).amount + " w:" + this.playerResourses.get(RESOURCETYPE.WOOD).amount);
			return false;
		}
	}
	
	
	private int uix = 600, uiy = 100, uiw = 200, uih = 40 , uip = 10;
	public void render(Graphics g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(uix- uip, uiy - (uih/2) - uip, uiw + uip*2, uih + uip*2);

		// Curr resources
		g.setColor(Color.white);
		g.drawString("STONE:" + this.playerResourses.get(RESOURCETYPE.STONE).amount +
				" WOOD:" + this.playerResourses.get(RESOURCETYPE.WOOD).amount, uix, uiy);
		
		// Posible Structures
		g.drawString("Structure: " + this.currStructure.name, uix, uiy + uip);
	}
	
}
