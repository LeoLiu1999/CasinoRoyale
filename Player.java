import cs1.Keyboard;
import java.util.ArrayList;

public class Player{

    protected String name;
    protected double _bal;
    //protected ArrayList<Integer> _hand = new ArrayList<Integer>();
    protected int _winStreak;
    protected int _loseStreak;

    public Player(String newName, double newBal){
	_winStreak = 0;
	_loseStreak = 0;
	name = newName;
	_bal = newBal;
    }

    public double checkBal(){
        return _bal;
    }

    public void win(double x){
	_winStreak += 1;
	_loseStreak = 0;
	_bal += x;
	System.out.println("You won " + x + " dollars!");
	System.out.println("You now have " + _bal +" dollars.\n");
    }

    public void lose(double x){
	_loseStreak += 1;
	_winStreak = 0;
	_bal -= x;
	System.out.println("You lost " + x + " dollars...");
	System.out.println("You now have " + _bal +" dollars.\n");	
    }
    // protected void addCard(int c){
    // 	_hand.add(c);
    // }
}
