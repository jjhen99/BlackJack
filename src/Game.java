public class Game {

    //create variables used by the Game class
    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes; //these store scores

    //constructor
    public Game(){

        //Set score to 0
        wins = 0; losses =0; pushes=0;

        //create a deck with 52 cards
        deck = new Deck(true);
        //create a new empty deck
        discarded = new Deck();

        //create people
        dealer = new Dealer();
        player = new Player();

        //Shuffle deck and start first round
        deck.shuffle();
        startRound();

        //Set score to 0
        //wins = 0; losses =0; pushes=0;
    }

    //method handles logic for each round
    private void startRound(){
        if (wins>0 || losses> 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting next round...Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

            //check deck has at least 4 cards
        if (deck.cardsLeft() < 4 ){
            deck.reloadDeckFromDiscard(discarded);
            }

        //Give dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //print hands
        dealer.printFirstHand();
        player.printHand();

        //Check if dealer has blackjack to start
        if(dealer.hasBlackjack()){
            dealer.printHand();

            //if player also has blackjack
            if(player.hasBlackjack()){
                //End round with push
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        //Check if player has blackjack to start
        //If we got here, we know dealer doesn't have blackjack
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue()>21){
            System.out.println("You have gone over 21.");
            //count losses
            losses ++;
            //start round over
            startRound();
        }

        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //Check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Push.");
            pushes ++;
        }

        startRound();

    }

}
