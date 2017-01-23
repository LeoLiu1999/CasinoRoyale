import cs1.Keyboard;

public class Slots extends Game{

    private String[] slot1 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};
    private String[] slot2 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};
    private String[] slot3 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};

    public void spin(){
	for (int x = 0; x < 1000; x += 1){
	    swap(slot1, (int)(Math.random() * 6), (int)(Math.random() * 6));
	    swap(slot2, (int)(Math.random() * 6), (int)(Math.random() * 6));
	    swap(slot3, (int)(Math.random() * 6), (int)(Math.random() * 6));
	}
	System.out.println(slot1[0] + "\t" + slot2[0] + "\t" + slot3[0]);
    }

    public boolean miniWin(){
	return (((!(slot1[0].equals(slot2[0])) && !(slot2[0].equals(slot3[0]))) && !(slot1[0].equals(slot3[0]))) || jackpot());
    }

    public boolean jackpot(){
	return ((slot1[0].equals(slot2[0])) && (slot1[0].equals(slot3[0])));
    }

    public void lose(){
	System.out.println("You lost...");
    }
    
    public static void printJackpot(double numBet){
	System.out.println("JACKPOT!!!\nYou won " + (10 * numBet) + " dollars!");
    }

    public static void printMini(double numBet){
	System.out.println("You won " + numBet + " dollars!");
    }
    
    public static void main(String[] args){
	Slots Player = new Slots();
	
	System.out.println("Welcome to our state-of-the-art Slot Machine! How much would you like to bet?");
        double numBet = Keyboard.readDouble();
	while (numBet <= 0){
	    System.out.println("I'm sorry, that value is invalid, try again.");
	    numBet = Keyboard.readDouble();
	}
	
	Player.spin();

	
	if (Player.jackpot()){
	    printJackpot(numBet);
	} else if(Player.miniWin()){
	    printMini(numBet);
	} else
	    Player.lose();
    }
}

