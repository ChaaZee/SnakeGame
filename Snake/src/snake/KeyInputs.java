package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter {

	private Snake s;
	private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	
	public KeyInputs(Snake s) {
		this.s = s;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			if(!down) {
				up = true;
				down = false;
				right = false;
				left= false;
				s.move('U');
			}
		}
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			if(!up) {
				up = false;
				down = true;
				right = false;
				left= false;
				s.move('D');
			}
		}
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			if(!right) {
				up = false;
				down = false;
				right = false;
				left= true;
				s.move('L');	
			}
		}
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			if(!left) {
				up = false;
				down = false;
				right = true;
				left= false;
				s.move('R');
			}
		}
	}
}
