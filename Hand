
public class Hand {
	Card[] handCards = new Card[0];
	Hand() {
		
	}
	public void addCard(Card ins){
		int newL = handCards.length;
		Card[] holdCards = new Card [newL+1];
		holdCards[0] = ins;
		int runner = 0;
		while(runner != newL) {
			holdCards[runner+1] = handCards[runner];
			runner++;
		}
		handCards = holdCards;
	}
	public void revCard(int num){
		int newL = handCards.length;
		Card[] holdCards = new Card [newL-1];
		int runner = 0, min = 0;
		while(runner != newL) {
	    	if(runner!=num) {
				holdCards[runner-min] = handCards[runner];
			} else {
				min = 1;
			}
			runner++;
		}
		handCards = new Card[0];
		handCards = holdCards;
	}
	public Card getCard(int num){
		return handCards[num];
	}
	public int numCards(){
		return handCards.length;
	}
}
