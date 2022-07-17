package snake;

import javax.swing.JFrame;

public class Window {

	public Window(Snake snake) {
		JFrame frame = new JFrame("Snake");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(snake);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		snake.start();
	}

}
