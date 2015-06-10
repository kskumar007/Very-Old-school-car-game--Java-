import java.awt.Color;
import java.awt.Graphics;


public class Road {
	public int streetX, streetY;
	private Street nextStreet;
	int y = 0;
	
	public Road() {
		nextStreet = createRoad(Game.streets);
	}
	
	public Street createRoad(Road l){
		Street k = new Street(92, y);
		
		return k;
	}
	
	public void update(){
		y+=6;
	}

	public void drawRoad(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(92, y, 11, 50);
		g.fillRect(147, y, 11, 50);
		g.fillRect(202, y, 11, 50);
		g.fillRect(257, y, 11, 50);
	}
	
	public Street getNewStreet(){
		return nextStreet;
	}
	
}
