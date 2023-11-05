package main;
import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {
	

		JFrame window = new JFrame();
		GamePanel gamePanel = new GamePanel();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Restaurmania");
		
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		gamePanel.startGameThread();
		
	}
} 