package gmail.dheide.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import gmail.dheide.mycomponents.TitleLabel;

public class Memory extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private int rows = 4;
	private int cols = 5;
	private Tile grid[][] = new Tile[rows][cols];
	private Random rand = new Random();
	private int row1,col1,row2,col2;
	private int tries = 0;
	private JPanel mainPanel = new JPanel(new GridLayout(rows,cols));
	

	public Memory() {
		
		initGUI();
		
		this.setTitle("Memory");
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initGUI() {
		
		TitleLabel titleLabel = new TitleLabel("Memory");
		this.add(titleLabel,BorderLayout.NORTH);
		
		ArrayList<Color> colorList = new ArrayList<Color>();
		
		Color white = Color.WHITE;
		colorList.add(white);
		colorList.add(white);
		Color blue = Color.BLUE;
		colorList.add(blue);
		colorList.add(blue);
		Color red = Color.RED;
		colorList.add(red);
		colorList.add(red);
		Color green = Color.GREEN;
		colorList.add(green);
		colorList.add(green);
		Color orange = Color.ORANGE;
		colorList.add(orange);
		colorList.add(orange);
		Color yellow = Color.YELLOW;
		colorList.add(yellow);
		colorList.add(yellow);
		Color black = Color.BLACK;
		colorList.add(black);
		colorList.add(black);
		Color pink = Color.PINK;
		colorList.add(pink);
		colorList.add(pink);
		Color cyan = Color.CYAN;
		colorList.add(cyan);
		colorList.add(cyan);
		Color gray = Color.GRAY;
		colorList.add(gray);
		colorList.add(gray);
		
		for(int r = 0; r < grid.length; r++) {
			
			for(int c = 0; c < grid[0].length; c++) {
				
				grid[r][c] = new Tile(colorList.remove(rand.nextInt(colorList.size())),r,c);
				grid[r][c].addMouseListener(new MouseAdapter() {
					
					public void mouseReleased(MouseEvent e) {
						
							row1 = Tile.getRow1();
							col1 = Tile.getCol1();
							row2 = Tile.getRow2();
							col2 = Tile.getCol2();
							System.out.println(Tile.getCount());
							
							if(Tile.getCount() == 0) {
								
								testEqual(grid[row1][col1], grid[row2][col2]);
								tries++;
								System.out.println(tries + " tries");
								
							}
						
					}
					
				});
				mainPanel.add(grid[r][c]);
				
			}
			
		}
		
		this.add(mainPanel);
		
		
		
		//button panel
		
		JPanel buttonPanel = new JPanel();
		
		JButton giveUpButton = new JButton("Give Up?");
		
		giveUpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for(int r = 0; r < grid.length; r++) {
					
					for(int c = 0; c < grid[0].length; c++) {
						
						grid[r][c].showColor();
						grid[r][c].cantuse();
						
					}
					
				}
				
				gaveUp();
				
			}
			
		});
		
		buttonPanel.add(giveUpButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public void gaveUp() {
	
		int input = JOptionPane.showConfirmDialog(this, "You give up.... Wanna try again?", "Giving up?", JOptionPane.YES_NO_OPTION);
		if(input == 0)
			reset();
		else
			System.exit(0);
		
	}
	
	public boolean didWin() {
		
		for(int r = 0; r < grid.length; r++) {
			
			for(int c = 0; c < grid[0].length; c++) {
				
				if(!grid[r][c].isFlipped() || !grid[r][c].useable()) {
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}
	
	public void testEqual(Tile t1, Tile t2) {
		
		if(!t1.getId().equals(t2.getId())) {
			
			t1.flip();
			t2.flip();
			
		} 
		
		if(didWin()) {
			
			String msg = "You Won! in " + tries + " tries\nDo you wanna play again?";
			int input = JOptionPane.showConfirmDialog(this, msg, "Play Again?",JOptionPane.YES_NO_OPTION);
			//System.out.println(input);
			if(input == 0) {
				
				this.reset();
				//System.out.println("yes");
				
			} else if(input == 1) {
				
				System.exit(0);
				//System.out.println("No");
				
			}
		}
		
	}
	
	public void reset() {
		
		tries = 0;
		
		mainPanel.removeAll();
		
		grid = new Tile[rows][cols];
		
		ArrayList<Color> colorList = new ArrayList<Color>();
		
		Color white = Color.WHITE;
		colorList.add(white);
		colorList.add(white);
		Color blue = Color.BLUE;
		colorList.add(blue);
		colorList.add(blue);
		Color red = Color.RED;
		colorList.add(red);
		colorList.add(red);
		Color green = Color.GREEN;
		colorList.add(green);
		colorList.add(green);
		Color orange = Color.ORANGE;
		colorList.add(orange);
		colorList.add(orange);
		Color yellow = Color.YELLOW;
		colorList.add(yellow);
		colorList.add(yellow);
		Color black = Color.BLACK;
		colorList.add(black);
		colorList.add(black);
		Color pink = Color.PINK;
		colorList.add(pink);
		colorList.add(pink);
		Color cyan = Color.CYAN;
		colorList.add(cyan);
		colorList.add(cyan);
		Color gray = Color.GRAY;
		colorList.add(gray);
		colorList.add(gray);
		
		for(int r = 0; r < grid.length; r++) {
			
			for(int c = 0; c < grid[0].length; c++) {
				
				grid[r][c] = new Tile(colorList.remove(rand.nextInt(colorList.size())),r,c);
				grid[r][c].addMouseListener(new MouseAdapter() {
					
					public void mouseReleased(MouseEvent e) {
						
							row1 = Tile.getRow1();
							col1 = Tile.getCol1();
							row2 = Tile.getRow2();
							col2 = Tile.getCol2();
							System.out.println(Tile.getCount());
							
							if(Tile.getCount() == 0) {
								
								testEqual(grid[row1][col1], grid[row2][col2]);
								tries++;
								System.out.println(tries + " tries");
								
							}
						
					}
					
				});
				mainPanel.add(grid[r][c]);
				
			}
			
		}
		
		mainPanel.revalidate();
		
	}
	
	public static void main(String[] args) {

		try {
			
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {

				new Memory();
				
			}
		});
		
	}

}
