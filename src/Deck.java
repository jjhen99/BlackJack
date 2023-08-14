import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){ //constructor - initiliases value
        deck = new ArrayList<Card>();
    }
    public void addCard(Card card){
        deck.add(card);
    }

    public String toString(){
        //String that holds everything we will return
        String output = "";

        //for each Card "card" in the deck
        for(Card card: deck) {
            //add card and escape caharcter for new line
            output += card;
            output += "\n";
        }
        return output;
    }


//This uses a boolean to make a deck with 52 cards. the command is Deck(true).
    //So if makeDeck == true, cards of each rank and each suit are added to the deck.
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //GO through all suits - for each suit in suit.values
            for(Suit suit : Suit.values()){
                //Go through all ranks - for each rank in rank.values
                for(Rank rank : Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    //Deck Shuffling method 1:
    //Loop that pulls one card at random from deck ArrayList to a new shuffled ArrayList
    //old deck is replaced with new ArrayList deck

    /*public void shuffle(){

        ArrayList<Card> shuffled = new ArrayList<Card>(); //shuffled deck = new deck
        //iterate through size of deck so each card can be pulled
        while (deck.size()>0){
            //pick a card at random from original deck
            //Select a random index to pull
            int cardToPull = (int)(Math.random()*(deck.size()-1)); //random card pulled
            //Add random card to new deck
            shuffled.add(deck.get(cardToPull)); //random card pulled added to new deck
            //Remove pulled card from original deck, so we don't accidently pull same card multiple times
            deck.remove(cardToPull); //card that was pulled from original deck is removed from original deck
        }
        deck = shuffled;
    } */

    //Deck shuffle method 2
    public void shuffle(){ //This returns nothing
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard(){//This returns a card
        //Take copy of first card from deck
        Card cardToTake = new Card(deck.get(0));
        //remove card from deck
        deck.remove(0);
        //give card back
        return cardToTake;
    }

    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }
    //return array list containing all cards in the deck
    public ArrayList<Card> getCards(){
        return deck;
    }

    //Empties this Deck
    public void emptyDeck(){
        deck.clear();
    }
    //arraylist of cards to be added to this deck
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    //Take all cards from discarded deck and add to this deck, shuffled
    //Clear old deck
    //@param discard - the deck we're getting cards from
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile and shuffling deck.");
    }

    public int cardsLeft(){
        return deck.size();
    }
}
