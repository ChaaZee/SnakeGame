package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class snakePart {
	
	public int xSnake;
	public int ySnake;
	//public int yVel, xVel;
	private int speed = 5;
	public Color color;
	//private int length;
	public int score = 0;
	
	public boolean up = false;
	public boolean down = false;
	public boolean right = false;
	public boolean left = false;
	
	public snakePart(int x, int y) {
		color = Color.green;
		//length = 3;
		xSnake = x;
		ySnake = y;
		//yVel = 0;
		//xVel = 0;
	}
	

	

	public void update(Snake s) {
		if(s.snake.get(0).xSnake >= s.WIDTH|| s.snake.get(0).xSnake <= -1) {
			//length = 3;
			s.score = 0;
			s.direction = ' ';
			s.resetSnake();
			//yVel = 0;
			//xVel = 0;
		}
		if(s.snake.get(0).ySnake >= s.HEIGHT || s.snake.get(0).ySnake <= -1) {
			//length = 3;
			s.score = 0;
			s.direction = ' ';
			s.resetSnake();
			//yVel = 0;
			//xVel = 0;
		}
	}

	/*
	public void down() {
		if(!up) {
			right = false;
			left = false;
			down = true;
			yVel = 1;
			xVel = 0;	
		}
	}
	
	public void up() {
		if(!down) {
			right = false;
			left = false;
			up = true;
			yVel = -1;
			xVel = 0;
		}
	}
	
	public void right() {
		if(!left) {
			up = false;
			down = false;
			right = true;
			yVel = 0;
			xVel = 1;
		}
	}
	
	public void left() {
		if(!right) {
			up = false;
			down = false;
			left = true;
			yVel = 0;
			xVel = -1;
		}
	}
	*/
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(xSnake, ySnake, 40, 40);
	}
	


}
