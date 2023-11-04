package main;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	//Screen Settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; //to scale up character to newer display
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenCol = 10;
	final int maxScreenRow = 15; 
	final int screenWidth = tileSize * maxScreenCol; //480 pixels
	final int screenHeight = tileSize * maxScreenRow; // 960 pixels
	
	//FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread; 
	Player player = new Player(this,keyH);

	//set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		//this.addKeyListener(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void run(){

		double drawInterval = 1000000000/FPS; // 60 fps 
		double nextDrawTime = System.nanoTime() + drawInterval; 

		while(gameThread != null)
		{
			
			//System.out.println("Game loop running!");

			update();

			repaint();
			try{
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;

				if(remainingTime < 0){
					remainingTime = 0;
				}

				Thread.sleep((long)remainingTime);

				nextDrawTime += drawInterval;

			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

	}
	public void update(){
		player.update();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		player.draw(g2);

		g2.dispose();
	}

}