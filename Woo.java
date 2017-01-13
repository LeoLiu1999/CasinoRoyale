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
    }
}
