import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainMenu extends JPanel {
	Runner screen;
	MainMenu(Runner screen) {
		setBackground(Color.blue);
		setVisible(true);
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getX() >= 600 && e.getX() <= 1000) {
					if (e.getY() >= 330 && e.getY() <= 330 + 150) {
						SwingUtilities.invokeLater(new Runnable() {
				            public void run() {
				            	UnoGame select= new UnoGame(screen);
				            }
				        });
					}
				}
				if (e.getX() >= 600 && e.getX() <= 1000) {
					if (e.getY() >= 580 && e.getY() <= 580 + 150) {
				        System.exit(0);
					}
				}

			}

		});
		this.screen = screen;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.yellow);
		Graphics2D g2 = (Graphics2D) g;
		int xPos = 160;
		int yPos = -50;
		int dispVal=10;
		double size = 2.5;
		
		Color shadeColor;
		int runner = 0;
		while (runner != 600) {
			int colorRun = (int)(runner/3);
			shadeColor = new Color(255 - colorRun, 0, 0 + (int) (colorRun / 2));
			g.setColor(shadeColor);
			g.drawLine(500 + runner, -600 + runner, 1400 + runner, 1400 + runner); // ratio of lines, 600 diff on x and
																					// 800 diff on y
			g.drawLine(501 + runner, -600 + runner, 1400 + runner, 1401 + runner);
			runner++;
		}
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.RED);
    	g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, (int)(90*size)));
    	g2.drawString("U", xPos+dispVal-(int)(24*size), yPos+(int)(160*size));
		g2.drawString("N", xPos+dispVal, yPos+(int)(240*size));
		g2.drawString("O", xPos+dispVal+(int)(24*size), yPos+(int)(320*size));
    	g.setColor(Color.WHITE);
    	g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, (int)(90*size)));
		g2.drawString("U", xPos+dispVal-(int)(28*size), yPos+(int)(156*size));
		g2.drawString("N", xPos+dispVal-(int)(4*size), yPos+(int)(236*size));
		g2.drawString("O", xPos+dispVal+(int)(20*size), yPos+(int)(316*size));
		

		g.setColor(new Color(230,230,0));
		g.fillRect(600, 330, 400, 150);
		g.fillRect(600, 580, 400, 150);
		g.setColor(Color.GREEN);
		g.fillRect(590, 570, 400, 150);
		g.fillRect(590, 320, 400, 150);
		g.setColor(Color.BLACK);
		g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		g2.drawString("Play New Game", 630, 410);
		g2.drawString("Quit", 630, 660);
		
	}
}





