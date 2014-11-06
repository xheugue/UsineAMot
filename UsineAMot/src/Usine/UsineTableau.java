package Usine;

public final class UsineTableau extends UsineAbstraite implements Usine{
	
	public final int TAILLE_INITIALE = 100;
	private String[] elements;
	int nbMots = 0;
	
	public UsineTableau(String path) {
		super(path);
	}

	@Override
	public boolean add(String mot) {
		if (elements == null)
			elements = new String[TAILLE_INITIALE];
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
			if (elements[i].matches(mot))
				nbOccurence++;
		
		return nbOccurence;
	}
	
}
