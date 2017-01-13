import cs1.Keyboard;

public class Woo{
    public static void main(String[] args){

	System.out.print("Welcome to the Casino Royale! Please enter the name of Player 1: ");
	String playerName = Keyboard.readString();
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ":");
	double playerBal = Keyboard.readDouble();
	Player player1 = new Player(playerName, playerBal);

	System.out.println();
	System.out.print("Now please enter the name of Player 2: ");
	playerName = Keyboard.readString();
	System.out.println();
	System.out.print("Please enter your current balance, " + playerName + ":");
	playerBal = Keyboard.readDouble();
	Player player2 = new Player(playerName, playerBal);
	
	// System.out.println("Welcome to the Casino Royale! How many people are in your group? (Between 2 and 4 please)");

	// String amount = Keyboard.readString();
	// int players;
	// String playerName;
	// double playerBal;
	// while (true){
	//     boolean turnOff = false;
	//     switch (amount){
	//     case "2":
	// 	players = 2;
	    
	// 	System.out.print("Please choose the name of the first player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player1 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the second player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player2 = new Player(playerName, playerBal);
	    
	// 	turnOff = true;
	//     case "3":
	// 	players = 3;

	// 	System.out.print("Please choose the name of the first player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player1 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the second player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player2 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the third player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player3 = new Player(playerName, playerBal);
	    
	// 	turnOff = true;
	//     case "4":
	// 	players = 4;

	// 	System.out.print("Please choose the name of the first player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player1 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the second player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player2 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the third player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player3 = new Player(playerName, playerBal);

	// 	System.out.print("Please choose the name of the fourth player: ");
	// 	playerName = Keyboard.readString();
	// 	System.out.println();
	// 	System.out.print("Please input your current balance, " + playerName + ": ");
	// 	playerBal = Keyboard.readDouble();
	// 	player4 = new Player(playerName, playerBal);
	    
	//         turnOff = true;
	//     default:
	// 	System.out.println("That value was invalid, please try again: ");
	// 	amount = Keyboard.readString();
	//     }
	// }

	
    }
}
