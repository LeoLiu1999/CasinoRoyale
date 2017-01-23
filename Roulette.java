import cs1.Keyboard;

public class Roulette extends Game{
    private static final String[] _wheel = {"g0","g00", "r1","b2","r3","b4","r5","b6","r7","b8","r9","b10","b11","r12","b13","r14","b15","r16","b17","r18","r19","b20","r21","b22","r23","b24","r25","b26","r27","b28","b29","r30","b31","r32","b33","r34","b35","r36"};
    private String USERCOLORBET;
    private String USERNUMBET;


    
    public static String spin(){
	String result =  _wheel[(int)(Math.random() * 38)];
	System.out.println("The wheel landed on " + result + ".");
	return result;
    }

    //public double getBets(){
    //	return _bets;
    //}

    public static boolean winColor(String color){
	return (color.equals(spin().substring(0,1)));
    }

    public static boolean winNumber(String num){
	return (num.equals(spin().substring(1)));
    }
    
    public static void main(String[] args){
    }
}
