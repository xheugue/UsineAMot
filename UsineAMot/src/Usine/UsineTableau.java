package Usine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsineTableau extends UsineAbstraite implements Usine{
	
	public final int TAILLE_INITIALE = 100;
	private String[] elements;
	int nbMots = 0;
	
	public UsineTableau(String path) {
		super(path);
		
		elements = new String[TAILLE_INITIALE];
		try {
			BufferedReader bR = new BufferedReader(new FileReader(new File(path)));
			String line;
			
			try {
				while ((line = bR.readLine()) != null)
				{
					add(line);
				}
			} catch (IOException e) {
				System.err.println("Erreur de flux");
				e.printStackTrace();
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public boolean add(String mot) {
		if (nbMots == elements.length)
		{
			String[] tmp = elements.clone();
			elements = new String[nbMots * 2];
			System.arraycopy(tmp, 0, elements, 0, nbMots);
		}
		elements[nbMots] = mot;
		nbMots++;
		return true;
	}

	@Override
	public boolean search(String mot) {
		int pos = 0;
		while (pos < nbMots && ! elements[pos].equals(mot))
			pos++;
		return pos < nbMots;
	}

	@Override
	public void removeAll() {
		elements = new String[TAILLE_INITIALE];
		
		nbMots = 0;
	}

	@Override
	public boolean remove(String mot) {
		int pos = 0;
		
		while (pos < nbMots && ! elements[pos].equals(mot))
			pos++;
		if (pos != nbMots)
		{
			while (pos != nbMots)
			{
				if (pos == nbMots - 1)
					elements[pos] = null;
				else
					elements[pos] = elements[pos+1];
				pos++;
			}
			nbMots--;
			return true;
		}
		return false;
	}

	@Override
	public int count(String mot) {
		int nbOccurence = 0;
		
		for(int i = 0; i < nbMots; i++)
			if (elements[i].contains(mot))
				nbOccurence++;
		
		return nbOccurence;
	}
	
}
