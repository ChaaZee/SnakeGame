package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	
	public int xApple;
	public int yApple;
	public static final int SIZE = 30;

	public Apple() {
		randPosition();
	}

	private void randPosition() {
		xApple = (int)(Math.random() * 16) * 40;
		yApple = (int)(Math.random() * 16) * 40;	
	}

	public void update(snakePart s, Snake sn) {
		if(s.xSnake + 20 >= xApple && s.xSnake + 20 <= xApple + SIZE
				&& s.ySnake + 20 <= yApple + SIZE && s.ySnake + 20 >= yApple) {
			randPosition();
			sn.addPoint();
			sn.increaseLength();
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(xApple + 5,yApple + 5, SIZE, SIZE);
	}

}
