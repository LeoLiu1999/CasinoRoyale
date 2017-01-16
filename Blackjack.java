import cs1.Keyboard;

public class Blackjack{

    final String[] suits = {"s","h","c","d"};
    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private double _bal;
    private double _bet;
    private int _playerTotal = 0;
    private int _dealerTotal = 0;
    private String[] _deck = new String[52];

    public Blackjack(double x){
	_bal = x;
    }

    public void setBal(double x){
	_bal = x;
    }

    public double getBet(){
	return _bet;
    }
    
    public void swap(String[] s, int a, int b){
        String c = s[a];
	s[a] = s[b];
	s[b] = c;
    }    
    public void shuffle(){
	for (int x = 0; x < 1000; x += 1){
	    swap(_deck,(int)(Math.random() * 52), (int)(Math.random() * 52));
	}
    }    

    public void createDeck(){
	int x = 0;
	for(String s:suits){
	    for(int i:nums){
		_deck[x] = s + i;
		x += 1;
	    }
	}
	shuffle();
    }

    public int drawCard(){
	if(_deck.length == 0){
	    createDeck();
	}
	String c = _deck[0];
	String[] d = new String[_deck.length - 1];
	for(int i = 1;i < _deck.length;i ++){
	    d[i - 1] = _deck[i];
	}
	_deck = d;
	int i = Integer.parseInt(c.substring(1));
	if(i > 10){
	    return 10;
	}
	else{
	    return i;
	}
    }
    
    public boolean Play(){
	createDeck();
	System.out.println("You sit down at the blackjack table");
	System.out.print("Place your bet:");
	//if( Keyboard.readDouble() > x._bal )	{
	//    System.out.print("Insufficient funds, place a lower bet:");
	//}
	//else{
	//    _bet = Keyboard.readDouble();
	//}
	_bet = Keyboard.readDouble();
	_playerTotal += drawCard();
	_playerTotal += drawCard();
	System.out.println(_playerTotal);
	_playerTotal = HitOrStand(_playerTotal);
	if(_playerTotal > 21){
	    System.out.println("Player bust.");
	    return false; //false if player bust
	}
	while(_dealerTotal < _playerTotal){
	    _dealerTotal += drawCard();
	    System.out.print("Dealer hits: ");
	    System.out.println(_dealerTotal);
	    if (_dealerTotal > 21){
		System.out.println("Dealer bust.");
		return true;
	    }
	}
	System.out.println("Dealer wins.");
	return false;
    }

    public int HitOrStand(int i){ //simulates player's turn
	int x = i;
	
	System.out.println("Hit or stand?");
	System.out.println("1: Hit");
	System.out.println("2: Stand");
	
	if(Keyboard.readInt() == 1){
	    x += drawCard();
	    System.out.println(x);
	    if(x > 21){
		return x;
	    }
	    else{
		HitOrStand(x);
	    }
	}
	else{
	    return x;
	}
	return x; //to get past compiler
    }	
}
