package Usine;

public final class UsineList extends UsineAbstraite implements Usine{

	private final class Element {
		String mot;
		Element suivant;
		
		public Element(String mot){
			this.mot = mot;
		}

		public String getMot() {
			return mot;
		}

		public Element getSuivant() {
			return suivant;
		}

		public void setSuivant(Element suivant) {
			this.suivant = suivant;
		}	
	}
	
	private Element tete,queue;
	
	public UsineList(String path) {
		super(path);
	}

	@Override
	public boolean add(String mot) {
		if (tete == null)
		{
			tete = new Element(mot);
			queue = tete;
		}
		else
		{
			queue.setSuivant(new Element(mot));
			queue = queue.getSuivant();
		}
		return true;
	}

	@Override
	public boolean search(String mot) {
		if (tete != null)
		{
			Element curseur = tete;
			while (curseur != null && !curseur.getMot().equals(mot))
				curseur = curseur.getSuivant();
			return curseur != null;
		}
		return false;
	}

	@Override
	public boolean remove(String mot) {
		if (tete != null)
		{
			if (tete.getMot().equals(mot))
			{
				tete = tete.getSuivant();
				return true;
			}
			Element curseur = tete;
			while (curseur.getSuivant() != null && !curseur.getSuivant().getMot().equals(mot))
				curseur = curseur.getSuivant();
			if (curseur.getSuivant() != null)
				curseur.setSuivant(curseur.getSuivant().getSuivant());
		}
		return false;
	}

	@Override
	public void removeAll() {
		tete = null;
		queue = null;
		
	}

	@Override
	public int count(String mot) {
		if (tete != null)
		{
			int compteur = 0;
			Element curseur = tete;
			
			while (curseur != null)
			{
				if (curseur.getMot().matches(mot))
					compteur++;
				curseur = curseur.getSuivant();
			}
			return compteur;
		}
		return 0;
	}

}
