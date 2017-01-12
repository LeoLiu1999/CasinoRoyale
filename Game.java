public class Game{
    final String[] suits = {"s","h","c","d"};
    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private String[] _deck = new String[52];
    private double _bet;
    private double _winnings;

    // protected void printDeck(){
    // 	String ret = "";
    // 	for (String s : _deck){
    // 	    ret += s + " ";
    // 	}
    // 	System.out.println(ret);
    // }

    protected void setBet(double amt){
	_bet = amt;
    }

    protected void swap(String[] s, int a, int b){
        String c = s[a];
	s[a] = s[b];
	s[b] = c;
    }

    protected void shuffle(){
	for (int x = 0; x < 1000; x += 1){
	    swap(_deck,(int)(Math.random() * 52), (int)(Math.random() * 52));
	}
    }

    protected void createDeck(){
        int x = 0;
	for(String s:suits){
	    for(int i:nums){
		_deck[x] = s + i;
		x += 1;
	    }
	}
	shuffle();
    }
    
    // public static void main(String[] args){
    // 	Game g = new Game();

    // 	g.createDeck();
    // 	g.printDeck();
    // }
}
