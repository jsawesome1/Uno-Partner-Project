import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class FrameTest {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
    private static void createAndShowGUI() {
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Screen());
        f.pack();
        f.setVisible(true);
        f.setSize(1400,800);
    } 
}
class Screen extends JPanel implements ActionListener {
	Timer tm = new Timer(30, this);
	
    public Screen() {
    	repaint();
    }
	public void actionPerformed(ActionEvent e) {

    }
    private void moveSquare(int x, int y) {
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        back(g);
        Card test1 = new Card(1,3);
        test1.setCords(900,100);
        cardAni a = new cardAni(5,2,600,200,1,g);
        cardAni b = new cardAni(9,0,100,200,0.5,g);
        cardAni c = new cardAni(test1, g);
        cardAni d = new cardAni(0,3,200,400,0.75,g);
    } 
    public void back(Graphics g) {
    	Color customColor = new Color(90,120,180);
        g.setColor(customColor);
       	g.fillRect(0, 0, 1850, 1050);
    }
}
