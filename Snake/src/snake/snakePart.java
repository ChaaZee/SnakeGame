package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class snakePart {
	
	public int xSnake;
	public int ySnake;
	private int speed = 5;
	public Color color;
	public int score = 0;
	
	public boolean up = false;
	public boolean down = false;
	public boolean right = false;
	public boolean left = false;
	
	public snakePart(int x, int y) {
		color = Color.green;
		xSnake = x;
		ySnake = y;
	}
	

	

	public void update(Snake s) {
		if(s.snake.get(0).xSnake >= s.WIDTH|| s.snake.get(0).xSnake <= -1) {
			s.score = 0;
			s.direction = ' ';
			s.resetSnake();
		}
		if(s.snake.get(0).ySnake >= s.HEIGHT || s.snake.get(0).ySnake <= -1) {
			s.score = 0;
			s.direction = ' ';
			s.resetSnake();
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(xSnake, ySnake, 40, 40);
	}
	


}
