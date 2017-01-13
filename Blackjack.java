import cs1.Keyboard;

public class Blackjack{

    final String[] suits = {"s","h","c","d"};
    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private double _bal;
    private double _bet = 0;
    private int _playerTotal = 0;
    private int _dealerTotal = 0;
    private String[] _deck = new String[52];

    public void setBal(double x){
	_bal = x;
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
	return Integer.parseInt(c.substring(1));
    }
    
    public void Go(Player x){
	createDeck();
	System.out.println("You sit down at the blackjack table.");
	Play(x);
	System.out.print("Play again? Y or N");
	if(Keyboard.readString().equals("Y")){
	    Go(x);
	}
        else{
	    return;
	}
	
    }
    
    public void Play(Player x){
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
	HitOrStand(x);
	while(_dealerTotal < _playerTotal){
	    _dealerTotal += drawCard();
	    System.out.println(_dealerTotal);
	    if (_dealerTotal > 21){
		System.out.println("Dealer bust. You win.");
		x.win(_bet);
		return;
	    }
	}
	System.out.println("You lost.");
	x.lose(_bet);
    }

    public void HitOrStand(Player x){
	System.out.println("Hit or stand?");
	System.out.println("1: Hit");
	System.out.println("2: Stand");
	if(Keyboard.readInt() == 1){
	    _playerTotal += drawCard();
	    System.out.println(_playerTotal);
	    if(_playerTotal > 21){
		x.lose(_bet);
		return;
	    }
	    else{
		HitOrStand(x);
	    }
	}
	else{
	    return;
	}
    }	
}
