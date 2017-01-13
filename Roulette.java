import cs1.Keyboard;

public class Roulette extends Game{
    private static final String[] _wheel = {"g0","g00", "r1","b2","r3","b4","r5","b6","r7","b8","r9","b10","b11","r12","b13","r14","b15","r16","b17","r18","r19","b20","r21","b22","r23","b24","r25","b26","r27","b28","b29","r30","b31","r32","b33","r34","b35","r36"};
    private String USERCOLORBET;
    private String USERNUMBET;


    
    public static String spin(){
	return _wheel[(int)(Math.random() * 38)];
    }

    //public double getBets(){
    //	return _bets;
    //}

    public static boolean winColor(String color){
	return (color.equals(spin().substring(0,1)));
    }

    public static boolean winNumber(String num){
	return (num.equals(spin().substring(1)));
    }
    
    public static void main(String[] args){
	
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
	    if (winNumber( USERNUMBET)){
		System.out.println("You won " +"ENTER BET" + " dollars!" );
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
	    if (winColor(USERCOLORBET)){
		System.out.println("You won " + "ENTER BET AMOUNT HERE" + " dollars!");
	    } else {
		System.out.println("You lost...");
	    }
	    
	}
    }
}
