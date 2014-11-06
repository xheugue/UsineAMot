package Usine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class UsineAbstraite implements Usine {
	
	private String path;

	public UsineAbstraite(String path) {
		this.path = path;
	}

	@Override
	public void doIt(String fichierAction) {
		try {
			BufferedReader bR = new BufferedReader(new FileReader(new File(fichierAction)));
			
			String line;
			String[] instruction;
			
			while ((line = bR.readLine()) != null)
			{
				instruction = line.split(" ");
				switch (instruction[0])
				{
				case "ajout":
					if (add(instruction[1]))
						System.out.println("OK");
					break;
					
				case "supprime":
					if (remove(instruction[1]))
						System.out.println("OK");
					else
						System.out.println("KO");
					break;
					
				case "cherche":
					if (search(instruction[1]))
						System.out.println(instruction[1]+" présent");
					else
						System.out.println(instruction[1]+" absent");
					break;
					
				case "ajoutDico":
					BufferedReader bRAjout = new BufferedReader(new FileReader(new File(instruction[1])));	
					String lineAjout;
					
					while ((lineAjout = bRAjout.readLine()) != null)
						add(lineAjout);
					
					bRAjout.close();
					break;
					
				case "compte":
					System.out.println("Il y a " + count(instruction[1])+ " occurence(s) du mot " + instruction[1]);
					break;
				}
			}
			bR.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur de flux");
			e.printStackTrace();
			System.exit(1);
		}
	}

}
