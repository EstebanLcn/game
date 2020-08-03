import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;
	
	
	private int totalBricks = 21;
	
	private Timer time;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXDir =-1;
	private int ballYDir =-2;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time = new Timer(delay, this);
		time.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592);
		
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(684, 0, 3, 592);
		
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);

		
		g.setColor(Color.yellow);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			time.start();	
				if(play) {
					if(new Rectangle(ballPosX,ballPosY, 20, 20 ).intersects (new Rectangle(playerX, 550, 100, 8))) {
						ballYDir = -ballYDir;
					}
					ballPosX += ballXDir;
					ballPosY += ballYDir;
					if(ballPosX < 0) {
						ballXDir = -ballXDir;

					}
					if(ballPosY < 0) {
						ballYDir = -ballYDir;

					}
					if(ballPosX > 670) {
						ballXDir = -ballXDir;

					}
				}
			repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX>=600) {
				playerX = 600;
			}else {
				moveRight();
			}
		}
if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	if(playerX<10) {
		playerX = 10;
	}else {
		moveLeft();

	}
		}
	}

	private void moveRight() {
		play = true;
		playerX += 20;
	}
	private void moveLeft() {
		play = true;
		playerX -= 20;
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}