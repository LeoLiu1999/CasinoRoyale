public class Roulette extends Game{
    private final String[] _wheel = {"g0","g00", "r1","b2","r3","b4","r5","b6","r7","b8","r9","b10","b11","r12","b13","r14","b15","r16","b17","r18","r19","b20","r21","b22","r23","b24","r25","b26","r27","b28","b29","r30","b31","r32","b33","r34","b35","r36"};
    
    public String spin(){
	return _wheel[Math.random() * 38];
    }

    public double getBets(){
	return _bets;
    }

    public boolean winColor(){
	return (USERCOLORBET.equals(spin().subString(0,1)));
    }

    public boolean winNumber(){
	return (USERNUMBET.equals(spin().subString(1)));
    }
    
    public static void main(String[] args){
	System.out.println("Do you want to bet on number or color?");
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
    }
}
