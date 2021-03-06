import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CardAni {
	Color cardColor;
	int xPos, yPos;
	double size;
	int value;
	String display;
	Boolean special;
	public CardAni(Card base, Graphics g) { // card class already made
		xPos = base.xPos;
		yPos = base.yPos;
		size = base.size;
		value = base.value;
		cardColor = base.cardColor;
		if(value==10)
    		display = "+2";
    	else
    		display = ""+value+"";
		special = false;
		if(value == 10)
			special = true;
    	paintCard(g);
    }
    public CardAni(int num, int color, int x, int y, double scale, Graphics g) { //no actually card class made or being passed
    	if(color == 0)
    		cardColor = Color.BLUE;
    	if(color == 1)
    		cardColor = Color.RED;
    	if(color == 2)
    		cardColor = Color.GREEN;
    	if(color == 3)
    		cardColor = new Color(230,230,0);
    	xPos = x;
    	yPos = y;
    	size = scale;
    	value = num;
    	special = false;
		if(value == 0)
			special = true;
    	if(num==10)
    		display = "+2";
    	else
    		display = ""+num+"";
    	paintCard(g);
    }
    protected void paintCard(Graphics g) {
        cardFrame(g);
        colorIn(g);
        cardText(g);
    } 
    public void cardText(Graphics g) {
    	int dispVal = (int)(100*size);
    	if(special)
    		dispVal = (int)(75*size);
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, (int)(100*size)));
		g.drawString(display, xPos+dispVal, yPos+(int)(150*size));
		//g.drawString("Cancel", 1045, 535);
    }
    
    public void colorIn(Graphics g) {    	
        g.setColor(cardColor);
       	g.fillRect(xPos+(int)(20*size), yPos+(int)(20*size), (int)(210*size), (int)(360*size)); // 100, 160
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
    public void setCords(int x, int y, Graphics g) {
		xPos = x;
		yPos = y;
		paintCard(g);
	}
}
