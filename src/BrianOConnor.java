import java.awt.Color;
import java.awt.Graphics;

public class BrianOConnor{
	
	public int velX, velY;
	
	public BrianOConnor() {
		velX = 165;
		velY = 400;
	}

	public void drawUserCar(Graphics g) {
			int boxSize = 30;
			g.setColor(Color.red);
			g.fillRect(velX, velY, boxSize, boxSize + 20);
	}

	public void tick() {
		for (int i = 0;i<Game.cars2.size();i++) {

			if (Game.cars2.get(i).x==velX && Game.cars2.get(i).y - 60 < velY && Game.cars2.get(i).y + 60 > velY) {

			if (Game.cars2.get(i).x==velX && Game.cars2.get(i).y < velY &&Game.cars2.get(i).y + 50 > velY) {


				Game.gameRunning = false;
			}
			}
			if(Game.cars2.get(i).y == Game.HEIGHT - 40){
				Game.score += 1;
				if(Game.score %20 == 0){
					if(Game.speed <= 30){
						Game.speed -= 5;
					}else{
						Game.speed -= 10;
					}
				}
			}	
		}
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}
