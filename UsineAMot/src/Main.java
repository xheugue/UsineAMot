import Usine.*;

public class Main {

	public static void main(String[] args){
		UsineList usine = new UsineList("Dictionnaire.txt");
		usine.doIt("action.txt");
	}

}
