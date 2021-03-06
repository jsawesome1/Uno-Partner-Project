import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Card {

	int xPos, yPos;
	double size;
	Color cardColor;
	int value;
	int colVal;
	boolean special;
	public Card(int number, int color) { //1-9 color numbers and +2s are the value of 0
		colVal = color;
		if(color == 0)
    		cardColor = Color.BLUE;
    	if(color == 1)
    		cardColor = Color.RED;
    	if(color == 2)
    		cardColor = Color.GREEN;
    	if(color == 3)
    		cardColor = new Color(230,230,0);
    	special = false;
    	if(number == 10)
    		special = true;
    	value = number;
	}
	public Card(int number) { //non colored cards
		value = number;
		special = true;
	}
	public int cardNum() {
		return value;
	}
	public int cardCol() { 
		return colVal;
	}
	public void setCords(int x, int y, double z) {
		xPos = x;
		yPos = y;
		size = z;
	}
}

