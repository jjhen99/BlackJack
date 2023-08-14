public abstract class Person { //cannot be used to create classes, can only be accessed by another class
    //abstract because person isnt individual object - only player and dealer. person shares logic.
    private Hand hand;
    private String name;

    //construct create a new person

    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    //method for player to get a hand
    public Hand getHand(){
        return this.hand;
    }

    //method to set the hand returns nothing
    public void setHand(Hand hand){ //parameters
        this.hand = hand; //instance variable
    }// if hand = hand, parameter = instance variable and it wont work. Need to use this.hand = hand.

    //method to get a name
    public String getName(){
        return this.name;
    }

    //method to set the name
    public void setName(String name){
        this.name = name;
    }

    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
    //prints persons hand
    public void printHand(){
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + "Valued at: " + this.hand.calculatedValue()); //by using this.hand, we are distinguishing it from hand
        //we could also use hand = h for example instead of this.hand = hand
    }

    public void hit(Deck deck, Deck discard){
        //If no cards left in deck
    if (!deck.hasCards()){
        deck.reloadDeckFromDiscard(discard);
    }
    this.hand.takeCardFromDeck(deck);
    System.out.println(this.name + " gets a card");
    this.printHand();
    }

}
