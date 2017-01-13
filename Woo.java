import cs1.Keyboard;

public class Woo{
    public static void main(String[] args){

	System.out.print("Welcome to the Casino Royale! What is your name? ");
	String playerName = Keyboard.readString();
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ":");
	double playerBal = Keyboard.readDouble();
	Player player = new Player(playerName, playerBal);

	System.out.println();

	System.out.println("Which game would you like to play?");
	System.out.println("\t(1)Slots");
	System.out.println("\t(2)Roulette");
	System.out.println("\t(3)Blackjack");
	System.out.println();
	System.out.print("Choice: ");
	String choice = Keyboard.readString();

	while((!choice.equals("1")) && (!choice.equals("2")) && (!choice.equals("3"))){
	    System.out.print("I'm sorry, that value is invalid. Please try again: ");
	    choice = Keyboard.readString();
	}

	/*============================================
	  Slots
	  ============================================*/
	if (choice.equals("1")){
	    Slots Player = new Slots();
	
	    System.out.println("Welcome to our state-of-the-art Slot Machine! How much would you like to bet?");
	    double numBet = Keyboard.readDouble();
	    while (numBet <= 0){
		System.out.println("I'm sorry, that value is invalid, try again.");
		numBet = Keyboard.readDouble();
	    }
	
	    Player.spin();

	
	    if (Player.jackpot()){
		Slots.printJackpot(numBet);
	    } else if(Player.miniWin()){
		Slots.printMini(numBet);
	    } else{
		Player.lose();
	    }
	}
	/*============================================
	  End of Slots
	  ============================================*/
	
	    


	/*============================================
	  Roulette
	  ============================================*/
	if (choice.equals("2")){
	    
	    //double bet = setBet();
	    int numOrColor = 0;
	    while (numOrColor != 2 && numOrColor != 1){
		System.out.println("Would you like to bet on number(1) or color(2)?");
		numOrColor = Keyboard.readInt();
	    }

	    //User bets on a NUMBER
	    //==================================
	    String USERNUMBET = "";
	    if (numOrColor == 1){
		System.out.println("Which number would you like to bet on? 00, 0, 1, 2, ..., 36" );
		USERNUMBET = Keyboard.readString();
		if (Roulette.winNumber( USERNUMBET)){
		    System.out.println("You won " +"ENTER BET AMOUNT HERE" + " dollars!" );
		} else {
		    System.out.println("You lost...");
		}
	    }

	    //User bets on a COLOR
	    //==================================
	    String USERCOLORBET = "";
	    if (numOrColor == 2){
		System.out.println("Would you like to bet on red(r), black(b), or green(g)");
		USERCOLORBET = Keyboard.readString();
		if (Roulette.winColor(USERCOLORBET)){
		    System.out.println("You won " + "ENTER BET AMOUNT HERE" + " dollars!");
		} else {
		    System.out.println("You lost...");
		}
	    }
	}
	/*============================================
	  End of Roulette
	  ============================================*/
    }
}
