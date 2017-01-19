import cs1.Keyboard;

public class RouletteDriver{
    public static void main(String[] args){
	

	    
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

		System.out.println("You won " + betAmt * 35 + " dollars!" );
		player.win(betAmt * 34);
	    }
	    else {
		player.lose(betAmt);
		
	    }
	}
    }
}
