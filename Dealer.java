public class Dealer extends Player{
    public Dealer(String n,double b){
        super(n,b);
    }
    public boolean playBlackjack(int p, int d){
	if(d <= p){
	    return true;
	}
	else{
	    return false;
	}
    }
}
