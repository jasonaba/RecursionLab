import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CityPanel extends JPanel implements ActionListener{
	Timer timer;
	double scale;
	
	public CityPanel() {
		setBackground(Color.black);
		timer = new Timer(40, this);
		timer.start();
		scale = 1;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.white);
		g2.drawString("Zoom test", 10, 20);
		g2.translate(getWidth()/2, getHeight()/2);
		g2.scale(scale, scale);
		g2.translate(-getWidth()/2, -getHeight()/2);
		
		
		
		drawCity(g2, 0, 0, getWidth(), getHeight(), 0);
	}
	
	private void drawCity(Graphics2D g, int x, int y, int w, int h, int d) {
		if(d>6 || w<20 || h<20) return;
		
		
		
		//draw rectangle borders of city image
		g.setColor(new Color(0, 150-d*15, 30));
		g.drawRect(x, y, w, h);
		
		int newH = (int)(h*0.5);
		int newW = (int)(w*.5);
		int newX = x + (w-newW)/2;
		int newY = y + (h-newH)/2;
		drawCity(g, newX, newY, newW, newH, d+1);
		
		//add buildings
		
		int margin = (int)(w*0.08);//buffer region
		
		int ix = x + margin;
		int iy = y + margin;
		int innerW = w-2*margin;
		int innerH = h - 2*margin;
		
		int buildings  =5;
		int bw = innerW/buildings;
		
		for(int i = 0; i<buildings; i++) {
			if(i%3 == 2) continue;//empty gaps to look more like a city
			
			int bx = ix + i*bw;//offset by the margin
			int by = iy;
			double ratio = 0.2 + 0.5 * (i%2);
			int bh = (int)(innerH*ratio);//to create different sized buildings
			
			
			
			int shade = 50 + d * 15;
			g.setColor(new Color(0, shade, 160));
		    g.fillRect(bx, iy + innerH - bh, bw - 2, bh);

		    g.setColor(new Color(255, 150-d*15, 30));
		    g.drawRect(bx, iy + innerH - bh, bw - 2, bh);

		}
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		scale *= 1.01;
		if(scale>4) {
			scale = 1;
		}
		this.repaint();
	}
	
}