package main;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
	Player playerone = new Player(this,keyH,150, 400, 1);
	Player playertwo = new Player(this,keyH,200, 400, 2);
	Player playerthree = new Player(this,keyH,250, 400, 3);
	
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
		int fishStatus = 0;
		int meatStatus = 0;
	    int dessertStatus = 0;
	    int vegetableStatus = 0;
	    int daysRemaining = 5;
	    int daysCounter = 0;
	    int orderPay = 0;
	    long framecounter = 1;
	    String orderName = "";
	    String[] lineArray= new String[6];
	    boolean changeval = false;
        
	    try{
            InputStream is = getClass().getResourceAsStream("/orders/Orders.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
        
			while(gameThread != null)
			{
				long modtime = (framecounter%(400));
				
				if(modtime == 0)
				{
					System.out.println("true");
					changeval = true;
				}
	            
				if (daysRemaining >= 0 && fishStatus == 0 && meatStatus == 0 && dessertStatus == 0 && vegetableStatus == 0 ) { 
	            		
	        		if((line = br.readLine()) != null)
	        		{
	            		if (line.equals("Day")) {
	                    daysCounter++;
	                    daysRemaining--;
	                    fishStatus = 0;
	                    meatStatus = 0;
	                    dessertStatus = 0;
	                    vegetableStatus = 0;
		                } else {
		                    lineArray = line.split(" ");
		                    orderName = lineArray[0];
		                    fishStatus = Integer.parseInt(lineArray[1]);
		                    meatStatus = Integer.parseInt(lineArray[2]);
		                    dessertStatus = Integer.parseInt(lineArray[3]);
		                    vegetableStatus = Integer.parseInt(lineArray[4]);
		                    orderPay = Integer.parseInt(lineArray[5]);
		                    System.out.println("Day: " + daysCounter);
		                    System.out.println("Order: " + orderName +
		                            " Fish Status: " + fishStatus +
		                            " Meat Status: " + meatStatus +
		                            " Dessert Status: " + dessertStatus +
		                            " Vegetable Status: " + vegetableStatus +
		                            " Order Pay: " + orderPay);
		                }
	        		}
		       }
	        
	        
			
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
			
			
			//update(pressedval, changeval);
			if(pressedval == 1)
				if(boundcheck(playerone.getX(), playerone.getY()))
					playerone.update();
					if(fishStation(playerone.getX(), playerone.getY()));
					if(meatStation(playerone.getX(), playerone.getY()));
					if(dessertStation(playerone.getX(), playerone.getY()));
					if(vegStation(playerone.getX(), playerone.getY()));
			if(pressedval == 2)
				if(boundcheck(playertwo.getX(), playertwo.getY()))
					playertwo.update();
					if(fishStation(playertwo.getX(), playerone.getY()));
					if(meatStation(playertwo.getX(), playerone.getY()));
					if(dessertStation(playertwo.getX(), playerone.getY()));
					if(vegStation(playertwo.getX(), playerone.getY()));
			if(pressedval == 3)
				if(boundcheck(playerthree.getX(), playerthree.getY()))
					playerthree.update();
					if(fishStation(playerthree.getX(), playerone.getY()));
					if(meatStation(playerthree.getX(), playerone.getY()));
					if(dessertStation(playerthree.getX(), playerone.getY()));
					if(vegStation(playerthree.getX(), playerone.getY()));
					

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
			framecounter++;
		}
			
        br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        

	}
	
	//public void update(int pressedval){
	/*	if(pressedval == 1)
			if(boundcheck(playerone.getX(), playerone.getY()))
				playerone.update();
				fishStation(playerone.getX(), playerone.getY());
				meatStation(playerone.getX(), playerone.getY());
				dessertStation(playerone.getX(), playerone.getY());
				vegStation(playerone.getX(), playerone.getY());
		if(pressedval == 2)
			if(boundcheck(playertwo.getX(), playertwo.getY()))
				playertwo.update();
				fishStation(playertwo.getX(), playertwo.getY());
				meatStation(playertwo.getX(), playertwo.getY());
				dessertStation(playertwo.getX(), playertwo.getY());
				vegStation(playertwo.getX(), playertwo.getY());
		if(pressedval == 3)
			if(boundcheck(playerthree.getX(), playerthree.getY()))
				playerthree.update();
				fishStation(playerthree.getX(), playerthree.getY());
				meatStation(playerthree.getX(), playerthree.getY());
				dessertStation(playerthree.getX(), playerthree.getY());
				vegStation(playerthree.getX(), playerthree.getY());
	}*/

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		playerone.draw(g2);
		
		playertwo.draw(g2);
		
		playerthree.draw(g2);
		
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		
		g2.drawString("test", 200, 520); //dishname
		
		g2.drawString("Fish: ", 60 , 560);
		
		g2.drawString("Meat: ", 60, 600);
		
		g2.drawString("Dessert: ", 200, 560);
		
		g2.drawString("Vegetables: ", 200, 600);

		g2.dispose();
	}
	public boolean fishStation(int x, int y)
	{
		boolean isfish = false;
		if(y >= 20 && y <= 200 && x >= 28 && x <= 130)
		{
			isfish = true;
			System.out.println("fish!!!");
			return isfish;
		}
		return isfish;
	}
	
	public boolean meatStation(int x, int y)
	{
		boolean ismeat = false;
		if(y>=20 && y<=200 && x>=300 && x<=400)
		{
			ismeat= true;
			System.out.println("Steak!!!");
			return ismeat;
		}
		return ismeat;
		
	}
	public boolean dessertStation(int x, int y)
	{
		boolean isdessert = false;
		if(y>=300 && y<=480 && x>=310 && x<=400)
		{
			isdessert= true;
			System.out.println("Dessert!!!");
			return isdessert;
		}
		return isdessert;
		
	}
	
	public boolean vegStation(int x, int y)
	{
		boolean isvegatable = false;
		if(y>=300 && y<=480 && x >= 28 && x <= 130)
		{
			isvegatable= true;
			System.out.println("Vegtable!!!");
			return isvegatable;
		}
		return isvegatable;
		
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