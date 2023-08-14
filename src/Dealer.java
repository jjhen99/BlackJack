public class Dealer extends Person {
    public Dealer(){

        //name dealer "Dealer
        super.setName("Dealer"); //use super because of extend - call parent class setName
    }

    //Find out what first card is, without revealing second
    //Print dealers first hand, one card face down.
    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }
}
