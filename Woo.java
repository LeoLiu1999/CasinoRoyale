import cs1.Keyboard;

public class Woo{
    public static void main(String[] args){

	System.out.print("Welcome to the Casino Royale! What is your name? ");
	String playerName = Keyboard.readString();
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ": ");
	double playerBal = Keyboard.readDouble();
	Player player = new Player(playerName, playerBal);

	System.out.println();
	
	while (true){
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
	
		while((!choice.equals("1")) && (!choice.equals("2")) && (!choice.equals("3")) && (!choice.equals("4"))){
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
		    double betAmt;
		    //while (!(betAmt > 0)){
		    //	System.out.print("Please input how much money you would like to bet: ");
		    //	betAmt = Keyboard.readDouble();
		    //	System.out.println();
		    //}

		    //User bets on a NUMBER
		    //==================================
		    String USERNUMBET = "";
		    if (numOrColor == 1){
			System.out.println("Which number would you like to bet on? 00, 0, 1, 2, ..., 36" );
			USERNUMBET = Keyboard.readString();
			betAmt = 0.00;
			while (!(betAmt > 0)){
			    System.out.println("Please input how much money you would like to bet");
			    betAmt = Keyboard.readDouble();
			}
			if (Roulette.winNumber( USERNUMBET)){
<<<<<<< HEAD
=======
			    System.out.println("You won " + betAmt * 35 + " dollars!" );
>>>>>>> 639f049cd3f659021e62657a28c2d918ccc8afbb
			    player.win(betAmt);
			}
			else {
			    player.lose(betAmt);
			}
		    }

		    //User bets on a COLOR
		    //==================================
		    String USERCOLORBET = "";
		    if (numOrColor == 2){
			
			System.out.println("Would you like to bet on red(r), black(b), or green(g)");
			USERCOLORBET = Keyboard.readString();

			while((!USERCOLORBET.equals("r")) && (!USERCOLORBET.equals("b")) && (!USERCOLORBET.equals("g"))){
			    System.out.print("I'm sorry, that value is invalid. Please try again: ");
			    USERCOLORBET = Keyboard.readString();
			}

			betAmt = 0.00;
			while (!(betAmt > 0)){
			    System.out.println("Please input how much money you would like to bet");
			    betAmt = Keyboard.readDouble();
			}
			
			if (Roulette.winColor(USERCOLORBET)){
<<<<<<< HEAD
			    player.win(betAmt);
=======
			    if(USERCOLORBET.equals("g")){
				System.out.println("You won " + betAmt * 17 + " dollars!");
			    } else {
				System.out.println("You won " + betAmt + " dollars!");
			    }
>>>>>>> 639f049cd3f659021e62657a28c2d918ccc8afbb
			} else {
			    player.lose(betAmt);
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
	    
		System.out.print("Would you like to play again? Yes(1) No(2) ");
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
