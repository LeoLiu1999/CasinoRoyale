import cs1.Keyboard;

public class Woo{
    //HELPERS----------------------------------------------------------------------------------
    public static boolean checkInString(String[] s, String x){ //Checks if the given String array contains the given String
	for (String p:s){
	    if (p.equals(x)){
		return true; //breaks loop and returns true if String was found
	    }
	}
	return false; //returns false if no instance of the String was found
    }
    public static double getValidBet(Player player,double bet){ //Makes sure user input is a valid numerical value when asked for bets
	System.out.println();
	double num = bet;
	while (num > player.checkBal() || num <= 0 || Double.isNaN(num)){ //Bad cases: bet <=0, bet is more than the user has, bet is not a numerical value
	       	if (Double.isNaN(num)){
       		    System.out.print("Please enter a numerical value: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num > player.checkBal()){
       		    System.out.print("Please enter a value that is less than or equal to your balance: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num <= 0){
       		    System.out.print("Please enter a value above 0: $");
       		    num = Keyboard.readDouble();
       		}
       	}
	return num; //returns the bet once the qualities above are satisfied
    }
    //-----------------------------------------------------------------------------------------

    public static void main(String[] args){

	System.out.print("Welcome to the Casino Royale! What is your name? ");
	String playerName = Keyboard.readString(); //Asks user for their name
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ": $");
	double playerBal = Keyboard.readDouble(); //Asks user for their starting balance
        while (playerBal <= 0 || Double.isNaN(playerBal)){ //Bad cases: balance <=0 or balance is not a numerical input
	    if (Double.isNaN(playerBal)){ //checks if user input was "not a number"
		System.out.print("Please enter a numerical value: $");
		playerBal = Keyboard.readDouble();
	    }
	    if (playerBal <= 0){ //checks if user input was negative
		System.out.print("Please enter a value greater than 0: $");
		playerBal = Keyboard.readDouble();
	    }
	}

	Player player = new Player(playerName, playerBal); //Creates new instance of Player based on given inputs

	System.out.println();
	
	while (true){ //Infinite loop until user decides to exit (choice 4)
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
	    while(playAgain){ //Valid until user chooses choice 4
		while((!choice.equals("1")) && (!choice.equals("2")) && (!choice.equals("3")) && (!choice.equals("4"))){ //Bad cases: input is not 1, 2, 3, or 4
		    System.out.print("I'm sorry, that value is invalid. Please try again: ");
		    choice = Keyboard.readString();
		}


		/*============================================
		  Slots
		  ============================================*/
		if (choice.equals("1")){
		    Slots machine = new Slots();
		
		    System.out.println("Welcome to our state-of-the-art Slot Machine!");
		    System.out.print("How much would you like to bet? $");
		    double numBet = getValidBet(player,Keyboard.readDouble()); //asks user for VALID bet

		    machine.spin();

	
		    if (machine.jackpot()){
		        System.out.println("JACKPOT");
			player.win(numBet * 10); //Player wins 10* what they bet when they get a jackpot
		    }
		    else if(machine.miniWin()){
		        player.win(numBet); //Player wins what they bet when they get a miniwin
		    } 
		    else{
			player.lose(numBet); //Player loses what they bet otherwise
		    }
		}
		/*============================================
		  End of Slots
		  ============================================*/
	
	    


		/*============================================
		  Roulette
		  ============================================*/
		if (choice.equals("2")){ 
		    String numOrColorIn = "";
		    while (!numOrColorIn.equals("1") && !numOrColorIn.equals("2")){ //Bad cases: input is not 1 or 2
			System.out.print("Would you like to bet on number(1) or color(2)? ");
			numOrColorIn = Keyboard.readString();
		    }
		    
		    int numOrColor = Integer.parseInt(numOrColorIn);

		    //User bets on a NUMBER
		    //==================================
		    String USERNUMBET = "";
		    String[] numbers = {"00","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36"};  //Collection of possible numbers for when the user bets on a number
		    if (numOrColor == 1){
			System.out.print("Which number would you like to bet on? 00, 0, 1, 2, ..., 36: " );
			USERNUMBET = Keyboard.readString();
			while (!checkInString(numbers,USERNUMBET)){ //While the input is not one of the numbers in the array above
			    System.out.print("That input was invalid, please try again: ");
			    USERNUMBET = Keyboard.readString(); //Ask for the input again
			}
			System.out.print("Please enter how much you would like to bet: $");
			double numBet = getValidBet(player,Keyboard.readDouble()); //asks user for VALID bet

			if (Roulette.winNumber(USERNUMBET)){
			    player.win(numBet * 34); //Player wins more if they bet on a number (smaller chances)
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
		        double numBet = getValidBet(player,Keyboard.readDouble()); //asks user for VALID bet
			
			if (Roulette.winColor(USERCOLORBET)){
			    if(USERCOLORBET.equals("g")){ //in the case where a user wins on GREEN
				player.win(numBet * 17);
			    }
			    else { //in the case where the user wins on RED or BLACK
				player.win(numBet);
			    }
			}
			else { //in the case where the player loses
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
		    Blackjack bj = new Blackjack(playerBal); //Blackjack is run on the driver in the directory
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
		    return    ; //exits the game if the user chooses choice 4
		}

		if (player.checkBal() <= 0){
		    System.out.println("You're broke :c");
		    return    ; //kicks the user out if they run out of money
		}
	    
		System.out.print("Would you like to play again? Yes(1) No(2): ");
		String input = Keyboard.readString();

		while((!input.equals("1")) && (!input.equals("2"))){ //Bad cases: input is not 1 or 2
		    System.out.print("I'm sorry, that value is invalid. Please try again: ");
		    input = Keyboard.readString();
		}
		if (input.equals("2")){
		    playAgain = false; //takes the player back to the game selection menu
		}
		if (input.equals("1")){ //takes the player back to the beginning of the game they previously played
		    playAgain = true;
		}
	    }
	}
    }
}
