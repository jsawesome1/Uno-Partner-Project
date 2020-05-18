import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
class Screen extends JPanel implements ActionListener {
	Timer tm = new Timer(30, this);
	Hand CompA;
	Hand Player;
	Hand CompB;
	Hand down;
	boolean select = false, win = false;
	int selected = 0;
	int turn = 0;
	int superDraw = 0;
	Card selectedCard;
    public Screen(Hand holdPlayer, Hand holdCompA, Hand holdCompB, Hand holdDown) {
    	repaint();
    	Player = holdPlayer;
    	CompA = holdCompA;
    	CompB = holdCompB;
    	down = holdDown;
    	addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(win) 
					System.exit(0);
				if ((e.getX() >= 105 && e.getX() <= 305)&&(e.getY() >= 325 && e.getY() <= 425)) {
					if(select)
						if(checkCard(selectedCard)) {
							playCard(Player, selectedCard);
						}
				} else if ((e.getX() >= 355 && e.getX() <= 555)&&(e.getY() >= 325 && e.getY() <= 425)) {
					if(superDraw != 0) {
			        	while(superDraw!=0) {
			                Player.addCard(newCard());
			                superDraw--;
			        	}
			        }
					Player.addCard(newCard());
			        turn++;
					repaint();
				} else {
					int x=0, y=0;
					int run = 0, mod = 0;
		    		while(run!=Player.numCards()) {
		            	if(run<=(Player.numCards())/2) 
		            		y-=10;
		            	else
		            		y+=10;
		            	x = 50+(run*(320-(Player.numCards()*17)));
		            	y += 500;
		            	if((Player.numCards()%2==0)&&(run==((Player.numCards())/2)-1))
		            		y+=7;
		            	//System.out.println(" a "+x+" "+y);
		            	if (e.getX() >= x && e.getX() <= x+290) {
							if (e.getY() >= y && e.getY() <= y+400) {
								select = true;
								selected = run;
								repaint();
							}
						}
		            	x = 0;
		            	y = 0;
		            	run++;
		    		}
	            }
			}
		});
    }
	public void actionPerformed(ActionEvent e) {

    }
	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        back(g);

        prevCard(g);
        comp1(g);
        comp2(g);
        deck(g);
        player(g);
        if(select)
        	selCard(g);
        buttonUse(g);
        buttonDraw(g);
        if(win)
        	celeb(g);
        if(turn == 1)
        	compTurn(CompA);
        if(turn == 2)
        	compTurn(CompB);
        if(turn == 3)
        	turn = 0;
    }
    public void buttonDraw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g.setColor(Color.ORANGE);
		g.fillRect(350, 320, 200, 100);
		g.setColor(Color.BLACK);
		g.drawRect(350, 320, 200, 100);
		g.setColor(Color.WHITE);
		g.fillRect(355, 325, 200, 100);
		g.setColor(Color.BLACK);
		g.drawRect(355, 325, 200, 100);
		g.setColor(Color.BLACK);
		g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		g2.drawString("DRAW", 400, 390);
    }
    public void buttonUse(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g.setColor(Color.ORANGE);
		g.fillRect(100, 320, 200, 100);
		g.setColor(Color.BLACK);
		g.drawRect(100, 320, 200, 100);
		g.setColor(Color.WHITE);
		g.fillRect(105, 325, 200, 100);
		g.setColor(Color.BLACK);
		g.drawRect(105, 325, 200, 100);
		g.setColor(Color.BLACK);
		g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 40));
		g2.drawString("USE", 160, 390);
    }
    public void compTurn(Hand comp) {
    	int run = 0;
    	if(comp.numCards()==0) {
    		win = true;
    		repaint();
    		return;
    	}
        while(run!=comp.numCards()) {
        	Card a = (comp.getCard(run));
        	if(checkCard(a)) {
        		selected = run;
        		selectedCard = a;
        		playCard(comp, a);
        		return;
        	}
        	run++;
        }
        turn++;
        if(superDraw != 0) {
        	while(superDraw!=0) {
                comp.addCard(newCard());
                superDraw--;
        	}
        }
        comp.addCard(newCard());
        repaint();
    }
    public boolean checkCard(Card hold) {
    	Card top = down.getCard(0);
    	//System.out.println("howdy" + top.cardCol()+" "+  top.cardNum()+" ");
    	//System.out.println("lol  " + hold.cardCol()+" "+ hold.cardNum()+" ");
    	if(superDraw !=0) {
    		if(top.cardCol() == hold.cardCol()) {
        		if((top.cardNum() == 10)&&(hold.cardNum() == 10)) {
        			return true;
        		} else if((top.cardNum() != 10)&&(hold.cardNum() != 10)) {
        			return true;
        		}
        	}
        	if(top.cardNum() == hold.cardNum())
        		return true;
    	} else {
    		if(top.cardCol() == hold.cardCol())
    			return true;
        	if(top.cardNum() == hold.cardNum())
        		return true;
    	}
    	
    	return false;
    }
    public void playCard(Hand eh, Card hold) {
    	select = false;
    	System.out.println(" tunr atk");
        addTurn(eh);
    	down.addCard(hold);
    	if(down.numCards()==4)
    		down.revCard(3);
    	if(selectedCard.cardNum()==10)
    		superDraw += 2;
    	eh.revCard(selected);
    	repaint();
    }
    public Card newCard() {
		int number = (int)(Math.random()*11);
		int color = (int)(Math.random()*4);
		Card hold = new Card(number,color);
		return hold;
	}
    public void player(Graphics g) {
    	int run = 0;
        int mod = 0;
    	//System.out.println("how     dy numcardol " + Player.numCards() + " ");
        while(run!=Player.numCards()) {
        	if(run<=(Player.numCards())/2) 
        		mod-=10;
        	else
        		mod+=10;
        	Card a = (Player.getCard(run));
        	try {
            	a.setCords(50+(run*(320-(Player.numCards()*17))),500+mod,1);
            	CardAni hold = new CardAni(a, g);
        	} catch(Exception e) {
        		System.out.println(run+"  ardol " + Player.numCards() + " ");
        	}
        	if((Player.numCards()%2==0)&&(run==((Player.numCards())/2)-1))
        		mod+=7;
        	run++;
        }
    }
    public void addTurn(Hand che) {
    	System.out.println(" win? "+che.numCards());
    	if(che.numCards()-1==0) {
    		win = true;
    		repaint();
    		return;
    	}
    	turn++;
    }
    public void celeb(Graphics g) { 
    	Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g.setColor(Color.ORANGE);
		g.fillRect(90, 90, 1600, 800);
		g.setColor(Color.BLACK);
		g.drawRect(90, 90, 1600, 800);
		g.setColor(Color.WHITE);
		g.fillRect(100, 100, 1600, 800);
		g.setColor(Color.BLACK);
		g.drawRect(100, 100, 1600, 800);
		if(Player.numCards()==0) {
			g.setColor(Color.BLACK);
			g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 240));
			g2.drawString("You Won!", 350, 390);
			g2.drawString("Exit", 350, 680);
		} else {
			g.setColor(Color.BLACK);
			g2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 240));
			g2.drawString("You Lost!", 350, 390);
			g2.drawString("Exit", 350, 680);
		}
    }

    public void prevCard(Graphics g) {
        int mod = 0;
        int run=down.numCards();
        while(run!=0) {
        	if(run == 1) {
        		Card a = (down.getCard(run-1));
            	a.setCords(1620-(run*160),20,1);
            	CardAni hold = new CardAni(a, g);
        	} else {
        		Card a = (down.getCard(run-1));
            	a.setCords(1620-(run*160),50-(run*7),0.8);
            	CardAni hold = new CardAni(a, g);
        	}
        	run--;
        }
    }
    public void comp1b(Graphics g) {
    	int run = 0;
        int mod = 0;
        while(run!=CompA.numCards()) {
        	if(run<=(CompA.numCards())/2) 
        		mod-=7;
        	else
        		mod+=7;
        	Card a = (CompA.getCard(run));
            a.setCords(50+(run*(81-(CompA.numCards()*4))),60+mod,0.6);
            CardAni hold = new CardAni(a, g);
        	if((CompA.numCards()%2==0)&&(run==((CompA.numCards())/2)-1))
        		mod+=7;
        	run++;
        }
    }
    public void comp1(Graphics g) {
    	int run = 0;
        int mod = 0;
        while(run!=CompA.numCards()) {
        	if(run<=(CompA.numCards())/2) 
        		mod-=7;
        	else
        		mod+=7;
        	CardBack hold = new CardBack(50+(run*(81-(CompA.numCards()*4))),60+mod,0.6,g);
        	if((CompA.numCards()%2==0)&&(run==((CompA.numCards())/2)-1))
        		mod+=7;
        	run++;
        }
    }
    public void deck(Graphics g) {
    	int run = 0;
        while(run!=20) {
        	CardBack hold = new CardBack(1500+(run*2),530+(run*2),0.7,g);
        	run++;
        }
    }
    public void comp2(Graphics g) {
    	int run = 0;
        int mod = 0;
        while(run!=CompB.numCards()) {
        	if(run<=(CompB.numCards())/2) 
        		mod-=7;
        	else
        		mod+=7;
        	CardBack hold = new CardBack(700+(run*(81-(CompB.numCards()*4))),60+mod,0.6,g);
        	if((CompB.numCards()%2==0)&&(run==((CompB.numCards())/2)-1))
        		mod+=7;
        	run++;
        }
    }
    public void selCard(Graphics g) {
    	int run = 0;
        int mod = 0;
       	while(run!=Player.numCards()) {
       		if(run<=(Player.numCards())/2) 
           		mod-=10;
           	else
           		mod+=10;
       		if(run == selected) {
               	Card a = (Player.getCard(run));
               	selectedCard = a;
               	a.setCords(40+(run*(320-(Player.numCards()*17))),490+mod,1.05);
               	CardAni hold = new CardAni(a, g);
       		}
       		if((Player.numCards()%2==0)&&(run==((Player.numCards())/2)-1))
           		mod+=7;
       		run++;
        }
    }
    public void back(Graphics g) {
    	Color customColor = new Color(90,120,180);
        g.setColor(customColor);
       	g.fillRect(0, 0, 1850, 1050);
    }
}


/*
 		Card test1 = new Card(1,3);
        test1.setCords(900,100);
        cardAni a = new cardAni(5,2,600,200,1,g);
        cardAni b = new cardAni(9,0,100,200,0.5,g);
        cardAni c = new cardAni(test1, g);
        cardAni d = new cardAni(0,3,200,400,0.75,g);
        cardAni z = new cardAni(4,3,100,100,1.75,g);
        CardBack e = new CardBack(100,300,0.75,g);

        CardBack f = new CardBack(500,300,1,g);

*/
