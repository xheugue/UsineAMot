import Usine.*;

public class Main {

	public static void main(String[] args){
		
		if (args.length == 3 && args[1].equals("-f"))
		{
			
			UsineArbre usine = new UsineArbre(args[0]);
			usine.doIt(args[2]);
		}
	}

}
