import java.util.Scanner;
public class Player extends Person{

    Scanner input = new Scanner(System.in);
    public Player(){
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard){
        int decision = 0;
        boolean getNum = true;

        //while getting a number is true
        while(getNum){
            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;
            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
            //dont close scanner
        }
        //if they decide to hit
        if (decision == 1) {
            //hit deck using deck and discard deck
            this.hit(deck, discard);
            //return(exit method) if they have black or bust
            if(this.getHand().calculatedValue()>20){
                return;
            }
            //if they didnt bust or get 21, allow to decide to hit or stand again by going back to same method
            else{
                this.makeDecision(deck, discard);
            }

            //if they type any number other than 1, they're standing

        }
        else{
            System.out.println("You stand.");

            }
    }




}
