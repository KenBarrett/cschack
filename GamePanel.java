package main;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//Screen Settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; //to scale up character to newer display
	
	final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 10;
	final int maxScreenRow = 15; 
	final int screenWidth = tileSize * maxScreenCol; //480 pixels
	final int screenHeight = tileSize * maxScreenRow; // 960 pixels
	
	Thread gameThread; 
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void run(){

		while(gameThread != null)
		{
			
			System.out.println("Game loop running!");

			//1 update position
			update();
			//2 Draw character
			repaint();
		}

	}
	public void update(){

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.white);

		g2.fillRect(100, 100, tileSize, tileSize);

		g2.dispose();
	}

}