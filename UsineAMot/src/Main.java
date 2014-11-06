import Usine.*;

public class Main {

	public static void main(String[] args){
		UsineArbre usine = new UsineArbre("Dictionnaire.txt");
		usine.doIt("action.txt");
	}

}
