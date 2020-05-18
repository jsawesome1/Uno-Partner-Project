import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CardBack {
	Color colorBack = new Color(100,100,100);
	int xPos, yPos;
	double size;
	int value;
    public CardBack(int x, int y, double scale, Graphics g) { //no actually card class made or being passed
    	xPos = x;
    	yPos = y;
    	size = scale;
    	paintCard(g);
    }
    public void setCords(int x, int y, Graphics g) {
		xPos = x;
		yPos = y;
		paintCard(g);
	}
    protected void paintCard(Graphics g) {
        cardFrame(g);
        colorIn(g);
        cardText(g);
    } 
    public void cardText(Graphics g) {
    	int dispVal = (int)(90*size);
		g.setColor(Color.RED);
    	g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, (int)(90*size)));
    	g.drawString("U", xPos+dispVal-(int)(24*size), yPos+(int)(160*size));
		g.drawString("N", xPos+dispVal, yPos+(int)(240*size));
		g.drawString("O", xPos+dispVal+(int)(24*size), yPos+(int)(320*size));
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, (int)(90*size)));
		g.drawString("U", xPos+dispVal-(int)(28*size), yPos+(int)(156*size));
		g.drawString("N", xPos+dispVal-(int)(4*size), yPos+(int)(236*size));
		g.drawString("O", xPos+dispVal+(int)(20*size), yPos+(int)(316*size));
		//g.drawString("Cancel", 1045, 535);
    }
    
    public void colorIn(Graphics g) {    	
        g.setColor(colorBack);
       	g.fillRect(xPos+(int)(20*size), yPos+(int)(20*size), (int)(210*size), (int)(360*size)); // 100, 160
       	g.setColor(Color.BLACK);
       	g.fillRect(xPos+(int)(60*size), yPos+(int)(75*size), (int)(130*size), (int)(260*size)); // 100, 160
    }
    public void cardFrame(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillArc(xPos, yPos+(int)(350*size), (int)(50*size), (int)(50*size), 180, 90);
       	g.fillArc(xPos+(int)(200*size), yPos+(int)(350*size), (int)(50*size), (int)(50*size), 270, 90);
       	g.fillArc(xPos, yPos, (int)(50*size), (int)(50*size), 90, 90);
       	g.fillArc(xPos+(int)(200*size), yPos, (int)(50*size), (int)(50*size), 0, 90);
       	
       	g.fillRect(xPos+(int)(25*size), yPos, (int)(200*size), (int)(25*size));
       	g.fillRect(xPos, yPos+(int)(25*size), (int)(25*size), (int)(350*size));
       	g.fillRect(xPos+(int)(225*size), yPos+(int)(25*size), (int)(25*size), (int)(350*size));
       	g.fillRect(xPos+(int)(25*size), yPos+(int)(375*size), (int)(200*size), (int)(25*size));
       	
       	g.setColor(Color.BLACK);
       	g.drawArc(xPos, yPos+(int)(350*size), (int)(50*size), (int)(50*size), 180, 90);
       	g.drawArc(xPos+(int)(200*size), yPos+(int)(350*size), (int)(50*size), (int)(50*size), 270, 90);
       	g.drawArc(xPos, yPos, (int)(50*size), (int)(50*size), 90, 90);
       	g.drawArc(xPos+(int)(200*size), yPos, (int)(50*size), (int)(50*size), 0, 90);
       	
       	g.drawRect(xPos+(int)(25*size), yPos, (int)(200*size), (int)(25*size));
       	g.drawRect(xPos, yPos+(int)(25*size), (int)(25*size), (int)(350*size));
       	g.drawRect(xPos+(int)(225*size), yPos+(int)(25*size), (int)(25*size), (int)(350*size));
       	g.drawRect(xPos+(int)(25*size), yPos+(int)(375*size), (int)(200*size), (int)(25*size));
       	
    }
}



