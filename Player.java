import cs1.Keyboard;

public class Player{

    private String name;
    private double _bal;
    private int _winStreak;
    private int _loseStreak;

    public Player(String newName, double newBal){
	_winStreak = 0;
	_loseStreak = 0;
	name = newName;
	_bal = newBal;
    }

    public void checkBal(){
	System.out.println("Name: " + name + ";\n" +
			   "Balance: " + _bal + ";");
    }

    public void win(double x){
	_winStreak += 1;
	_loseStreak = 0;
	_bal += x;
    }

    public void lose(double x){
	_loseStreak += 1;
	_winStreak = 0;
	_bal -= x;
    }
}
