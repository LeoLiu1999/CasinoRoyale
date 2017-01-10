public class Game{
    final String[] faces = {"s","h","c","d"};
    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private String[] _deck = new String[52];
    private double _bet;
    private double _winnings;

    protected void swap(int a, int b){
        String c = _deck[a];
	_deck[a] = _deck[b];
	_deck[b] = c;
    }

    protected void shuffle(){
	for (int x = 0; x < 1000; x += 1){
	    swap((int)(Math.random() * 52), (int)(Math.random() * 52));
	}
    }

    protected void createDeck(){
        int x = 0;
	for(String s:faces){
	    for(int i:nums){
		_deck[x] = s + i;
		x += 1;
	    }
	}

        
    }
    
    public static void main(String[] args){
	Game g = new Game();

	g.createDeck();
    }
}
