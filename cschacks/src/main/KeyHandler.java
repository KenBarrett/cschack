package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, onepressed, twopressed, threepressed;
	
	public void keyTyped(KeyEvent e){
	
	}
	public void keyPressed(KeyEvent e){
	
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			upPressed = true;
		}
		if(code == KeyEvent.VK_S)
		{
			downPressed = true;
		}
		if(code == KeyEvent.VK_A)
		{
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D)
		{
			rightPressed = true; 
		}
		if(code == KeyEvent.VK_1)
		{
			onepressed = true;
		}
		if(code == KeyEvent.VK_2)
		{
			twopressed = true;
		}
		if(code == KeyEvent.VK_3)
		{
			threepressed = true;
		}
		
	}
	public void keyReleased(KeyEvent e){
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			upPressed = false;
		}
		if(code == KeyEvent.VK_S)
		{
			downPressed = false;
		}
		if(code == KeyEvent.VK_A)
		{
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D)
		{
			rightPressed = false; 
		}
		if(code == KeyEvent.VK_1)
		{
			onepressed = false;
		}
		if(code == KeyEvent.VK_2)
		{
			twopressed = false;
		}
		if(code == KeyEvent.VK_3)
		{
			threepressed = false;
		}
	}
	
}