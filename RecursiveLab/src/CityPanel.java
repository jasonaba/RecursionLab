import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CityPanel extends JPanel{
	int depth, scale;

	public CityPanel() {
		this.setBackground(new Color(0,0,0));
		depth = 7;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawCity(g, 0, 0, this.getWidth(), this.getHeight(), 0);
		
		g.setColor(Color.white);
		g.drawString("Max Depth: " + depth, 10, 20);
	}
	
	public void drawCity(Graphics g, int x, int y, int w, int h, int d) {
		if(d>=depth || w<=10 || h<=10)//w<=10 || h<=10 safety net so thousands of tiny rectangles won't be drawn
			return;
		//make colors based on depth
		//low depth == bright | high depth == darker
		int shade = 255-d*25;
		shade = Math.max(shade, 50);//so it doesn't get toooooo dark
		
		g.setColor(new Color(30,30,30));
		
		// Draw city buildings recursively
		g.drawRect(x, y, w, h);
		
		int randW = (int)(w*((Math.random()*0.4)+0.3));
		int randH = (int)(h*((Math.random()*0.4)+0.3));
		
		if(d%2==0) {//if depth is even, vertical split
		drawCity(g, x, y, randW, h, d+1);
		drawCity(g, x+randW, y, w-randW, h, d+1);
		}
		else {//horizontal split
			drawCity(g, x, y, w, randH, d+1);
			drawCity(g, x, y+randH, w, h-randH, d+1);
		}
		
		if(d > 2 && Math.random() < 0.35) {
		    int newW = (int)(w * 0.4);
		    int newH = (int)(h * 0.4);

		    int direction = (int)(Math.random() * 4);

		    if(direction == 0) { // right
		        drawCity(g, x + w, y + h/4, newW, newH, d+1);
		    }
		    else if(direction == 1) { // left
		        drawCity(g, x - newW, y + h/4, newW, newH, d+1);
		    }
		    else if(direction == 2) { // down
		        drawCity(g, x + w/4, y + h, newW, newH, d+1);
		    }
		    else { // up
		        drawCity(g, x + w/4, y - newH, newW, newH, d+1);
		    }
		}
	}
	
}
