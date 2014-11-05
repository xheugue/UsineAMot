package Usine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
						System.out.println(instruction[1]+" pr�sent");
					else
						System.out.println(instruction[1]+" pr�sent");
					break;
					
				case "ajoutDico":
					try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
					    
						BufferedReader bRCopy = new BufferedReader(new FileReader(new File(instruction[1])));
						
						String lineCp;
						
						while((lineCp = bRCopy.readLine()) != null)
							out.println(lineCp);
					}catch (IOException e) {
					    System.err.println("Probl�me avec le fichier");
					}
					break;
					
				case "compte":
					System.out.println("Il y a " + count(instruction[1])+ "occurence(s) du mot" + instruction[1]);
					break;
				}
			}
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
