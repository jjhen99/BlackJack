public enum Suit {
    //Contains card suits and names
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");
     String suitName;

    Suit(String suitName){
        this.suitName = suitName;
    }
    public String toString(){
        return suitName;
    }
}
