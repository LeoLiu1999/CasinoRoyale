import cs1.Keyboard;

public class Slots extends Game{

    private String[] slot1 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};
    private String[] slot2 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};
    private String[] slot3 = {"peach","pear","cherry","grapefruit","orange","pomegranate"};

    public void spin(){
	for (int x = 0; x < 1000; x += 1){
	    swap(slot1, (int)(Math.random() * 6), (int)(Math.random() * 6));
	    swap(slot2, (int)(Math.random() * 6), (int)(Math.random() * 6));
	    swap(slot3, (int)(Math.random() * 6), (int)(Math.random() * 6));
	}
    }

    public boolean miniWin(){
	return (((!(slot1[0].equals(slot2[0])) && !(slot2[0].equals(slot3[0]))) && !(slot1[0].equals(slot3[0]))) || jackpot());
    }

    public boolean jackpot(){
	return ((slot1[0].equals(slot2[0])) && (slot1[0].equals(slot3[0])));
    }

    public static void main(String[] args){

    }
}
