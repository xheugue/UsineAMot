import Usine.UsineTableau;

public class Main {

	public static void main(String[] args){
		UsineTableau usine = new UsineTableau("Dictionnaire.txt");
		usine.doIt("action.txt");;
	}

}
