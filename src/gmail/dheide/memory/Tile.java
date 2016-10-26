package gmail.dheide.memory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tile extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	public static int r1, r2;
	public static int c1, c2;
	public static int count = 0;
	private boolean flipped = false;
	private Color id;
	private BufferedImage image;
	private int row;
	private int col;
	private boolean canUse = true;
	
	public Tile(Color id, int row, int col) {
		
		this.id = id;
		this.row = row;
		this.col = col;
		try {
			 
			 image = ImageIO.read(Tile.class.getResource("/imgs/Icon.png"));
			 
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "Couldnt find image");
			System.exit(0);
		
		}
		
		this.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				
				if(canUse) {
				
					count++;
					if(count > 2)
						count = 0;
					
					if(count != 0) {
					
						flip();	
						
						if(count == 1) {
							r1 = row;
							c1 = col;
						}
						
						if(count == 2){
							r2 = row;
							c2 = col;
						}
					
					}
				
				}
				
			}
			
		});
		
	}
	
	public void paintComponent(Graphics g) {
		
		if(flipped) {
			
			g.setColor(id);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
		} else {
			
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.drawImage(image, 0, 0, WIDTH, HEIGHT, this);
			
		}
		
	}
	
	public Dimension getPreferredSize() {
		
		Dimension size = new Dimension(WIDTH,HEIGHT);
		return size;
		
	}
	
	public void setId(Color id) {
		
		this.id = id;
		
	}
	
	public void flip() {
		
		flipped = !flipped;
		this.repaint();
		
	}
	
	public boolean isFlipped() {
		
		return flipped;
		
	}
	
	public static int getRow1() {
		
		return r1;
	
	}
	
	public static int getCol1() {
		
		return c1;
		
	}
	
	public static int getRow2() {
		
		return r2;
		
	}
	
	public static int getCol2() {
		
		return c2;
		
	}
	
	public static int getCount() {
		
		return count;
		
	}
	
	public Color getId() {
		
		return id;
		
	}
	
	public void cantuse() {
		
		canUse = false;
		
	}
	
	public boolean useable() {
		
		return canUse;
		
	}
	
	public void showColor() {
		
		flipped = true;
		this.repaint();
		
	}
}
