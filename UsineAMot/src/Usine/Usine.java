package Usine;

public interface Usine {
	public boolean add(String mot);
	public boolean search(String mot);
	public boolean remove(String mot);
	public void removeAll();
	public void doIt(String fichierAction);
	public int count (String mot);
}
