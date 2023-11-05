package main;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Tile.TileManager;
import entity.Player;

public class GamePanel extends JPanel implements Runnable{
	//Screen Settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; //to scale up character to newer display
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	public final int maxScreenCol = 10;
	public final int maxScreenRow = 15; 
	public final int screenWidth = tileSize * maxScreenCol; //480 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 960 pixels
	
	//FPS
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player playerone = new Player(this,keyH);
	Player playertwo = new Player(this,keyH);
	Player playerthree = new Player(this,keyH);

	//set player's default position
	//int playerX = 100;
	//int playerY = 100;
	//int playerSpeed = 4;
	
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

		int	pressedval = 1;
		double drawInterval = 1000000000/FPS; // 60 fps 
		double nextDrawTime = System.nanoTime() + drawInterval; 

		while(gameThread != null)
		{
			
			//System.out.println("Game loop running!");
			if(keyH.onepressed == true || keyH.twopressed == true || keyH.threepressed == true)
			{
				if(keyH.onepressed == true)
					pressedval = 1;
				if(keyH.twopressed == true)
					pressedval = 2;
				if(keyH.threepressed == true)
					pressedval = 3;
			}
			
			
			update(pressedval);

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
	
	public void update(int pressedval){
		if(pressedval == 1)
			if(boundcheck(playerone.getX(), playerone.getY()))
				playerone.update();
				fishStation(playerone.getX(), playerone.getY());
		if(pressedval == 2)
			if(boundcheck(playertwo.getX(), playertwo.getY()))
				playertwo.update();
				fishStation(playertwo.getX(), playertwo.getY());
		if(pressedval == 3)
			if(boundcheck(playerthree.getX(), playerthree.getY()))
				playerthree.update();
				fishStation(playerthree.getX(), playerthree.getY());
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		playerone.draw(g2);
		
		playertwo.draw(g2);
		
		playerthree.draw(g2);
		

		g2.dispose();
	}
	public boolean fishStation(int x, int y)
	{
		boolean isfish = false;
		if(y >= 20 && y <= 224 && x >= 28 && x <= 96)
		{
			isfish = true;
			System.out.println("fish!!!");
			return isfish;
		}
		return isfish;
	}
	
	public boolean boundcheck(int x, int y)
	{
		boolean canMove = true;
		if(y <= 20 && keyH.upPressed)
			canMove = false;
		if(y >= 620 && keyH.downPressed)
			canMove = false;
		if(x <= 28 && keyH.leftPressed)
			canMove = false;
		if(x >=400 && keyH.rightPressed)
			canMove = false;
		return canMove;
	}

}