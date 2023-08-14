public class Card {
//vars
    private Suit suit;
    private Rank rank;


//create a card with a given suit and rank
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue(){
        return rank.rankValue;
    }

    public Suit getSuit(){ //returns a suit
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");
    }

    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }
}
