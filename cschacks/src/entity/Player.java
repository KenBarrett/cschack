package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import javax.imageio.*;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH, int setx, int sety, int player) {
		this.gp = gp;
		this.keyH = keyH;

		setDefaultValues(setx, sety);
		if(player == 1)
			getPlayerImage();
		if (player == 2)
			getPlayerImage2();
		if(player == 3)
		getPlayerImage3();
	}
	public void setDefaultValues(int setx, int sety) {
		
		x = setx;
		y = sety;
		speed = 4;
		direction = "down";
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public String getDirection() {
		return direction;
	}
	public void getPlayerImage() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/down.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPlayerImage2() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPlayerImage3() {
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/down3.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyH.upPressed == true)
		{
			direction = "up";
			y -= speed;
		}
		else if(keyH.downPressed == true){
			direction = "down";
			y += speed;
		}
		else if(keyH.leftPressed == true)
		{
			direction = "left";
			x -= speed;
		}
		else if(keyH.rightPressed == true)
		{
			direction = "right";
			x += speed;
		}
	}
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//
//		//g2.fillRect(100, 100, tileSize, tileSize);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			image = up;
			break;
		
		case "down":
			image = down;
			break;
		
		case "left":
			image = left;
			break;
		
		case "right":
			image = right;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}