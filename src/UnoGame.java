
public class UnoGame {
	UnoGame(Runner screen) {
		Hand Player = new Hand();
		Hand CompA = new Hand();
		Hand CompB = new Hand();
		Hand Down = new Hand();
		int run = 0;
		while(run!=7) {
			Player.addCard(newCard());
			CompA.addCard(newCard());
			CompB.addCard(newCard());
			run++;
		}
		Down.addCard(newCard());
		
		screen.frame.getContentPane().removeAll();
		Screen select= new Screen(Player,CompA,CompB,Down);
		screen.frame.getContentPane().add(select);
		screen.frame.revalidate();
	}
	public Card newCard() {
		int number = (int)(Math.random()*11);
		int color = (int)(Math.random()*4);
		Card hold = new Card(number,color);
		return hold;
	}
}
