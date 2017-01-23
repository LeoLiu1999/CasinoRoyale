import cs1.Keyboard;

public class Woo{
    //HELPERS----------------------------------------------------------------------------------
    public static boolean checkInString(String[] s, String x){
	for (String p:s){
	    if (p.equals(x)){
		return true;
	    }
	}
	return false;
    }
    public static double getValidBet(Player player,double bet){
	System.out.println();
	double num = bet;
	while (num > player.checkBal() || num <= 0 || Double.isNaN(num)){
	       	if (Double.isNaN(num)){ //checks if input was "not a number"
       		    System.out.print("Please enter a numerical value: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num > player.checkBal()){ //cannot bet more than you have
       		    System.out.print("Please enter a value that is less than or equal to your balance: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num <= 0){ //cannot bet negative value
       		    System.out.print("Please enter a value above 0: $");
       		    num = Keyboard.readDouble();
       		}
       	}
	return num;
    }
    //-----------------------------------------------------------------------------------------

    public static void main(String[] args){

	System.out.print("Welcome to the Casino Royale! What is your name? ");
	String playerName = Keyboard.readString();
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ": $");
	double playerBal = Keyboard.readDouble();
        while (playerBal <= 0 || Double.isNaN(playerBal)){
	    if (Double.isNaN(playerBal)){ //checks if user input was "not a number"
		System.out.print("Please enter a numerical value: $");
		playerBal = Keyboard.readDouble();
	    }
	    if (playerBal <= 0){ //checks if user input was negative
		System.out.print("Please enter a value greater than 0: $");
		playerBal = Keyboard.readDouble();
	    }
	}

	Player player = new Player(playerName, playerBal);

	System.out.println();
	
	while (true){
	    System.out.println("CURRENT BALANCE: $" + player.checkBal());
	    System.out.println();
	    System.out.println("Which game would you like to play?");
	    System.out.println("\t(1)Slots");
	    System.out.println("\t(2)Roulette");
	    System.out.println("\t(3)Blackjack");
	    System.out.println();
	    System.out.println("\t(4)Exit");
	    System.out.print("Choice: ");
	    String choice = Keyboard.readString();

	    boolean playAgain = true;
	    while(playAgain){
		//check that user input was 1 or 2 or 3 or 4
		while((!choice.equals("1")) && (!choice.equals("2")) && (!choice.equals("3")) && (!choice.equals("4"))){
		    System.out.print("I'm sorry, that value is invalid. Please try again: ");
		    choice = Keyboard.readString();
		}


		/*============================================
		  Slots
		  ============================================*/
		if (choice.equals("1")){
		    Slots machine = new Slots();
		
		    System.out.println("Welcome to our state-of-the-art Slot Machine!");
		    System.out.print("How much would you like to bet? $:");
		    double numBet = getValidBet(player,Keyboard.readDouble());

		    machine.spin();

	
		    if (machine.jackpot()){
		        System.out.println("JACKPOT");
			player.win(numBet * 10);
		    }
		    else if(machine.miniWin()){
		        player.win(numBet);
		    } 
		    else{
			player.lose(numBet);
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
		    while (numOrColor != 2 && numOrColor != 1){ //will ask until valid choice is inputted
			System.out.print("Would you like to bet on number(1) or color(2)? ");
			numOrColor = Keyboard.readInt();
		    }

		    //User bets on a NUMBER
		    //==================================
		    String USERNUMBET = "";
		    String[] numbers = {"00","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36"};
		    if (numOrColor == 1){
			System.out.print("Which number would you like to bet on? 00, 0, 1, 2, ..., 36: " );
			USERNUMBET = Keyboard.readString();
			while (!checkInString(numbers,USERNUMBET)){
			    System.out.print("That input was invalid, please try again: ");
			    USERNUMBET = Keyboard.readString();
			}
			System.out.print("Please enter how much you would like to bet: $");
			double numBet = getValidBet(player,Keyboard.readDouble());

			if (Roulette.winNumber(USERNUMBET)){

			    System.out.println("You won " + numBet * 35 + " dollars!" );
			    player.win(numBet * 34);
			}
			else {
			    player.lose(numBet);
			}
		    }

		    //User bets on a COLOR
		    //==================================
		    String USERCOLORBET = "";
		    if (numOrColor == 2){
			
			System.out.print("Would you like to bet on red(r), black(b), or green(g)? ");
			USERCOLORBET = Keyboard.readString();

			while((!USERCOLORBET.equals("r")) && (!USERCOLORBET.equals("b")) && (!USERCOLORBET.equals("g"))){
			    System.out.print("I'm sorry, that value is invalid. Please try again: ");
			    USERCOLORBET = Keyboard.readString();
			}

			System.out.print("Please enter how much you would like to bet: $");
			double numBet = Keyboard.readDouble();
		        while (numBet > player.checkBal() || numBet <= 0 || Double.isNaN(numBet)){
			    if (Double.isNaN(numBet)){
				System.out.print("Please enter a numerical value: $");
				numBet = Keyboard.readDouble();
			    }
			    if (numBet > player.checkBal()){
				System.out.print("Please enter a value that is less than or equal to your balance: $");
				numBet = Keyboard.readDouble();
			    }
			    if (numBet <= 0){
				System.out.print("Please enter a value above 0: $");
				numBet = Keyboard.readDouble();
			    }
			}
			
			
			if (Roulette.winColor(USERCOLORBET)){
			    player.win(numBet);
			    if(USERCOLORBET.equals("g")){
				System.out.println("You won " + numBet * 17 + " dollars!");
				player.win(numBet * 17);
			    } else {
				System.out.println("You won " + numBet * 2 + " dollars!");
				player.win(numBet);
			    }
			} else {
			    player.lose(numBet);
			}
		    }
		}
		/*============================================
		  End of Roulette
		  ============================================*/

	
		/*============================================
		  Blackjack
		  ============================================*/
		if(choice.equals("3")){
		    Blackjack bj = new Blackjack(playerBal);
		    if(bj.Play()){
			player.win(bj.getBet());
		    }
		    else{
			player.lose(bj.getBet());
		    }
		}
		/*============================================
		  End of Blackjack
		  ============================================*/

		if(choice.equals("4")){
		    return    ;
		}

		if (player.checkBal() <= 0){
		    System.out.println("You're broke :c");
		    return    ;
		}
	    
		System.out.print("Would you like to play again? Yes(1) No(2): ");
		String input = Keyboard.readString();

		while((!input.equals("1")) && (!input.equals("2"))){
		    System.out.print("I'm sorry, that value is invalid. Please try again: ");
		    input = Keyboard.readString();
		}
		if (input.equals("2")){
		    playAgain = false;
		}
		if (input.equals("1")){
		    playAgain = true;
		}
	    }
	}
    }
}
