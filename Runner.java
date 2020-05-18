import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Runner {
    JFrame frame = new JFrame("Run");

    public static void main(String[] args) {
   	 new Runner();
    }
    public Runner() {
	   	 MainMenu main= new MainMenu(this);
	   	 JFrame.setDefaultLookAndFeelDecorated(true);
	   	 frame = new JFrame("UNO");
	   	 frame.getContentPane().add(main);
		 frame.setSize(1800,1000);
	   	 frame.setVisible(true);
	   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
