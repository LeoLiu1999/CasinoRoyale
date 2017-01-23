 import cs1.Keyboard;
import java.util.ArrayList;

public class Blackjack{

    final String[] suits = {"s","h","c","d"};
    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    private double _bal;
    private double _bet;
    private ArrayList<Integer> _playersHand = new ArrayList<Integer>();
    private ArrayList<Integer> _dealersHand = new ArrayList<Integer>(); 
    private String[] _deck = new String[52];
    private boolean _countCards = false;
    private int[] _dealtCards = new int[nums.length];
    //private int _dealtCardsIndex = 0;

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
	_dealtCards[Integer.parseInt(c.substring(1)) - 1] += 1;
	String[] d = new String[_deck.length - 1];
	for(int i = 1;i < _deck.length;i ++){
	    d[i - 1] = _deck[i];
	}
	_deck = d;
	int i = Integer.parseInt(c.substring(1));
	if(i > 10){
	    return 10;
	}
	else if(i == 1){
	    return 11;
	}
	else{
	    return i;
	}
    }
    
    public int totalValue(ArrayList<Integer> a){
	int ret = 0;
	for(int i:a)
	    ret += i;
	return ret;
    }

    public void countCards(){
	String in = Keyboard.readString();
	if(in.equals("Y")){
	    _countCards = true;
	}
	else if(in.equals("N")){
	    _countCards = false;
	}
	else{
	    System.out.println("Invalid input. Would you like to count cards?");
	    countCards();
	}
    }

    public void printDealtCards(){
	System.out.println("Cards that have been dealt:");
        for(int i = 0;i < _dealtCards.length;i ++){
	    if(_dealtCards[i] > 0){
		if(i == 0){
		    System.out.print("Aces:" + _dealtCards[i] + "\t");
		}
		else if(i == 10){
		    System.out.print("Jacks:" + _dealtCards[i] + "\t");
		}
		else if(i == 11){
		    System.out.print("Queens:" + _dealtCards[i] + "\t");
		}
		else if(i == 12){
		    System.out.print("Kings:" + _dealtCards[i] + "\t");
		}
		else{
		    System.out.print( (i + 1) + "s:" +  _dealtCards[i] + "\t");
		}
	    }
	}
    }
    public boolean Play(){
	createDeck();
	System.out.println("You sit down at the blackjack table");
	System.out.print("Would you like to count cards? You risk getting caught...  Y or N: ");
	countCards();		
	System.out.print("Place your bet:");
	double num = Keyboard.readDouble();
	while (num > _bal || num <= 0 || Double.isNaN(num)){
	       	if (Double.isNaN(num)){ //checks if input was "not a number"
       		    System.out.print("Please enter a numerical value: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num > _bal){ //cannot bet more than you have
       		    System.out.print("Please enter a value that is less than or equal to your balance: $");
       		    num = Keyboard.readDouble();
       		}
       		if (num <= 0){ //cannot bet negative value
       		    System.out.print("Please enter a value above 0: $");
       		    num = Keyboard.readDouble();
       		}
       	}
	
	_bet = num;
	_playersHand.add( drawCard() );
	_playersHand.add( drawCard() );
	System.out.println("You are dealt two cards...");
	System.out.print("Current value of your hand:");
	System.out.println(totalValue(_playersHand));

	HitOrStand(totalValue(_playersHand));
	if(totalValue(_playersHand) > 21){
	    System.out.println("Player bust.");
	    return false; //false if player bust
	}
	while(totalValue(_dealersHand) < totalValue(_playersHand)){
	    _dealersHand.add(drawCard());
	    System.out.print("Dealer hits: ");
	    System.out.println(totalValue(_dealersHand));
	    if (totalValue(_dealersHand) > 21){
		System.out.println("Dealer bust.");
		return true;
	    }
	}
	System.out.println("Dealer wins.");
	return false;
    }

    public void HitOrStand(int i){ //simulates player's turn
	//int x = i;

	if(_countCards)
	    printDealtCards();	
	System.out.println("Hit or stand?");
	System.out.println("1: Hit");
	System.out.println("2: Stand");
	
	if(Keyboard.readInt() == 1){
	    _playersHand.add(drawCard());
	    System.out.print("Current value of your hand:");
	    System.out.println(totalValue(_playersHand));
	    if(totalValue(_playersHand) > 21){
		return;
	    }
	    else{
		HitOrStand(totalValue(_playersHand));
	    }
	}
	else{
	    return ;
	}
    }	
}
