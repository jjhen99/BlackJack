import java.util.ArrayList;
public class Hand {

    private ArrayList<Card> hand;

    public Hand(){ //constructor - method that initialises value
        hand = new ArrayList<Card>();
    }

    //Create a takeCard() method to the Deck class that return top card from the deck, and removes it

    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    public String toString(){
        String output = "";
        for(Card card: hand){//for each card in hand
            output += card + " - ";
        }
        return output;
    }

    //Method to calculated value of hand
    public int calculatedValue(){
        //int variables that count the number of aces in the hand and the current total value
        int value = 0;
        int aceCount = 0;

        //For each card in hand

        for(Card card:hand){
            //Add card value to hand
            value += card.getValue();
            //Count how many aces have been added
            if (card.getValue() ==11){
                aceCount ++;
            }

        }
        //scenario where we have many aces, such as 10 + 11 + 1 > 21
        //set each ace to until get back under 21, if possible
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10; //if we have more than 0 aces and the valye is more than 21,
                // remove 1 ace from the aceCount by converting 11 to 1 by minusing 10.
            }
        }
        return value;
    }
    //Method to get first card from Dealer's hand
    public Card getCard(int idx){
        return hand.get(idx);
    }

    public void discardHandToDeck(Deck discardDeck){
        //copy cards from hand to discardDeck
        discardDeck.addCards(hand);

        //clear hand
        hand.clear();
    }
}
