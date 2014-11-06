package Usine;

public final class UsineArbre extends UsineAbstraite implements Usine{

	private final class Arbre {
		private String mot;
		private Arbre gauche;
		private Arbre droite;
		
		public Arbre(String mot){
			this.mot = mot;
		}
		
		public int comparerString(String m)
		{
			if (m.length() < mot.length())
			{
				return -1;
			}
			if (m.length() == mot.length())
			{
				if (mot.compareToIgnoreCase(m) < 0)
				{
					return -1;
				}
				if (mot.compareToIgnoreCase(m) > 0)
				{
					return 1;
				}
				
			}
			if (m.length() > mot.length())
			{
				return 1;
			}
			return 0;
		}
		
		public boolean add(String m){
			if (comparerString(m) < 0)
			{
				if (gauche == null)
					gauche = new Arbre(m);
				else
					gauche.add(m);
				return true;
			}
			else if (comparerString(m) > 0)
			{
				if (droite == null)
					droite = new Arbre(m);
				else
					droite.add(m);
				return true;
			}
			return false;
		}
		
		public boolean add(Arbre a){
			if (comparerString(a.getMot()) < 0)
			{
				if (gauche == null)
					gauche = a;
				else
					gauche.add(a);
				return true;
			}
			else if (comparerString(a.getMot()) > 0)
			{
				if (droite == null)
					droite = a;
				else
					droite.add(a);
				return true;
			}
			return false;
		}

		public boolean remove(String m) {
			
			if (comparerString(m) < 0)
			{
				if (gauche != null)
				{
					if (gauche.comparerString(m) == 0)
					{
						if (gauche.getDroite() != null && gauche.getGauche() != null)
						{
							gauche.getDroite().add(gauche.getGauche());
							gauche = gauche.getDroite();
						}
						else if (gauche.getGauche() != null)
						{
							gauche = gauche.getGauche();
						}
						else if (gauche.getDroite() != null)
						{
							gauche = gauche.getDroite();
						}
						else
							gauche = null;
						return true;
					}
					return gauche.remove(m);
				}
			}
			else if (comparerString(m) > 0)
			{
				if (droite != null)
				{
					if (droite.comparerString(m) == 0)
					{
						if (droite.getDroite() != null && droite.getGauche() != null)
						{
							droite.getDroite().add(droite.getGauche());
							droite = droite.getDroite();
						}
						else if (droite.getGauche() != null)
						{
							droite = droite.getGauche();
						}
						else if (droite.getDroite() != null)
						{
							droite = droite.getDroite();
						}
						else
							droite = null;
						return true;
					}
					return droite.remove(m);
				}
			}
			return false;
		}
		
		public int count(int compteur, String m) {
			if (mot.matches(m))
				compteur++;
			if (gauche != null && droite != null)
			{
				compteur = gauche.count(compteur, m);
				return droite.count(compteur, m);
			}
			else if (gauche != null)
			{
				return gauche.count(compteur, m);
			}
			else if (droite != null)
			{
				return droite.count(compteur, m);
			}
			return compteur;
		}
		
		public boolean search (String m)
		{
			if (comparerString(m) < 0)
			{
				if (gauche == null)
					return false;
				return gauche.search(m);
			}
			else if (comparerString(m) > 0)
			{
				if (droite == null)
					return false;
				return droite.search(m);
			}
			else if (comparerString(m) == 0)
			{
				return true;
			}
			return false;
		}
		
		public String getMot() {
			return mot;
		}
		
		public Arbre getGauche() {
			return gauche;
		}

		public Arbre getDroite() {
			return droite;
		}
	}
	
	private Arbre root;
	
	public UsineArbre(String path) {
		super(path);
	}

	@Override
	public boolean add(String mot) {
		if (root == null)
		{
			root = new Arbre(mot);
		}
		else
			root.add(mot);
		return false;
	}

	@Override
	public boolean search(String mot) {
		if (root == null)
			return false;
		return root.search(mot);
	}

	@Override
	public boolean remove(String mot) {
		if (root != null)
		{
			if (root.comparerString(mot) == 0)
			{
				if (root.getDroite() != null && root.getGauche() != null)
				{
					root.getDroite().add(root.getGauche());
					root = root.getDroite();
				}
				else if (root.getGauche() != null)
				{
					root = root.getGauche();
				}
				else if (root.getDroite() != null)
				{
					root = root.getDroite();
				}
				else
					root = null;
				return true;
			}
			else
				return root.remove(mot);
		}
		return false;
	}

	@Override
	public void removeAll() {
			root = null;
	}

	@Override
	public int count(String mot) {
		if (root == null)
			return 0;
		return root.count(0, mot);
	}

}
