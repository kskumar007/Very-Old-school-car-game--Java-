import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	public static final int ROWS = 25;
	public static final int COLS = 18;
	public static final int SIZE = 20;
	public static final int WIDTH = COLS * SIZE;
	public static final int HEIGHT = ROWS * SIZE;
	public static int speed = 30;
	public static List<Cars> cars2 = new ArrayList<Cars>();
	public static List<Road> streets2 = new ArrayList<Road>();
	public static BrianOConnor pw;
	public static Cars cars;
	public static Road streets;
	int timer = 0;
	public static int speedTimer = 16;
	public static  int score;

	private Thread runThread;
	private Graphics globalGraphics;

	static boolean gameRunning = false;

	public void paint(Graphics g) {
		globalGraphics = g.create();

		if (runThread == null) {
			runThread = new Thread(this);
			runThread.start();
			gameRunning = true;
		}
	}

	public Game() {
		pw = new BrianOConnor();
		cars = new Cars();
		streets = new Road();
		score = 0;
	}

	public void run() {
		while (gameRunning) {
			render(globalGraphics);
			pw.tick();

			if(timer>speedTimer){
				cars2.add(new Cars());
				streets2.add(new Road());
				timer=0;
			}
			for (int i = 0;i<cars2.size();i++) {
				cars2.get(i).update();
				streets2.get(i).update();
				
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			timer++;
		}
		endGame(globalGraphics);
	}

	public void render(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		pw.drawUserCar(g);
		
		for (int i = 0;i<cars2.size();i++) {
			cars2.get(i).drawCars(g);
			streets2.get(i).drawRoad(g);
			
		}
		drawRoad(globalGraphics);
		drawScore(globalGraphics);
		g.setColor(Color.white);
		g.fillRect(92, 0, 11, 5);
		g.fillRect(147, 0, 11, 5);
		g.fillRect(202, 0, 11, 5);
		g.fillRect(257, 0, 11, 5);
	}
	
	public void drawRoad(Graphics g){
		g.setColor(Color.white);
		g.fillRect(35, 0, 15, Game.WIDTH + 100);
		g.setColor(Color.white);
		g.fillRect(310, 0, 15, Game.WIDTH + 100);
	}
	
	public void drawScore(Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(0, Game.HEIGHT - 40, Game.WIDTH, 40);
		g.setColor(Color.white);
		g.drawString("score=" + score, 10, Game.WIDTH + 120);
	}
	
	private void endGame(Graphics g){
		g.setFont(new Font("Elephant", Font.BOLD, 40));
		g.setColor(Color.red);
		g.drawString("C.R.A.S.H", Game.WIDTH/2-110, Game.HEIGHT/2);
	}
}

