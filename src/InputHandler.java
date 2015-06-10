import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public InputHandler(Game game) {
		game.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		// right x = 1, y = 0
		if (keyCode == KeyEvent.VK_RIGHT && Game.pw.velX <= 255) {
			Game.pw.velX += 55;
		}
		// left x = -1, y = 0
		else if (keyCode == KeyEvent.VK_LEFT && Game.pw.velX >= 90) {
			Game.pw.velX -= 55;
		}
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	
	public void keyReleased(KeyEvent e) {
	

	}

	
	public void keyTyped(KeyEvent e) {
		

	}

}
