import cs1.Keyboard;

public abstract class Player{

    private double _bal;
    private int _winStreak;
    private int _loseStreak;

    public Player(){
	_winStreak = 0;
	_loseStreak = 0;
    }

    protected void setBal(double newBal){
	_bal = newBal;
    }

    protected void win(){
	_winStreak += 1;
	_loseStreak = 0;
    }

    protected void lose(){
	_loseStreak += 1;
	_winStreak = 0;
    }
}
