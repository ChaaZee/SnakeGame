package snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import snake.KeyInputs;

public class Snake extends Canvas implements Runnable {
	
	public static final int WIDTH = 640;//40x40 pixel square
	public static final int HEIGHT = 640;//16x16 square
	public boolean running = false;
	private Apple apple;
	private Thread gameThread;
	public ArrayList<snakePart> snake = new ArrayList<snakePart>();
	public int score = 0;
	final public int SIZE = 40;
	public char direction = ' ';
	

	public Snake() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		new Window(this);
		apple = new Apple();
		resetSnake();
		
		this.addKeyListener(new KeyInputs(this));
		this.setFocusable(true);
	}
	
	public void resetSnake() {
		snake.clear();
		snake.add(new snakePart(480, 280));
		snake.add(new snakePart(520, 280));
		snake.add(new snakePart(560, 280));
	}

	@Override
	public void run() {
		this.requestFocus();

		// game timer
		long lastTime = System.nanoTime();
		double amountOfTicks = 7.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				delta--;
				draw();
				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	public void update() {
		apple.update(snake.get(0), this);
		snake.get(0).update(this);
		collisionTest();
		move(direction);
		apple.update(snake.get(0), this);

	}
	
	public void draw() {
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		drawBackground(g);
		
		apple.draw(g);
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		drawScore(g);
		
		g.dispose();
		buffer.show();
	}
	
	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);
		g.setFont(font);
		g.drawString(scoreText, 300, 50);
	}
	
	private void drawBackground(Graphics g) {
		Color c1 = new Color(245, 245, 245);
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		/*for(int y = 0; y < HEIGHT; y += 40) {
			for(int x = 0; x < WIDTH; x += 80) {
				if(y/40 == 1 || y/40 == 3 || y/40 == 5 || y/40 == 7 || y/40 == 9 ||
						y/40 == 11 || y/40 == 13 || y/40 == 15) {
					g.fillRect(x + 40, y, 40, 40);
				} else {
					g.fillRect(x, y, 40, 40);
				}
			}
		}*/
	}
	
	public void move(char direction) {
		
		this.direction = direction;

        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).xSnake = snake.get(i - 1).xSnake;
            snake.get(i).ySnake = snake.get(i - 1).ySnake;
        }
		
        switch (direction) {
            case 'U':
            	snake.get(0).ySnake -= SIZE;
            	break;
            case 'D':
            	snake.get(0).ySnake += SIZE;
            	break;
            case 'L':
            	snake.get(0).xSnake -= SIZE;
            	break;
            case 'R':
            	snake.get(0).xSnake += SIZE;
            	break;
        }
    }
	
	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
		running = true;	
	}
	
	public void stop() {
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addPoint() {
		score++;
	}
	
	public void increaseLength() {
		snake.add(new snakePart(snake.get(snake.size() - 1).xSnake, snake.get(snake.size() - 1).ySnake));
	}
	
	public void collisionTest() {
		for(int i = 1; i < snake.size(); i++) {
			if(snake.get(0).xSnake == snake.get(i).xSnake && snake.get(0).ySnake == snake.get(i).ySnake) {
				resetSnake();
				score = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		new Snake();

	}

}
