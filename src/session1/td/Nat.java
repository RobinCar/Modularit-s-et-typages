package session1.td;

import hierarchie.SemiAnneauUnitaireEuclidien;

public interface Nat extends FabriqueNat<Nat>, SemiAnneauUnitaireEuclidien<Nat>{
	
	public boolean estNul();
	
	public Nat predecesseur();
	
	public int chiffre(int i);
	
	public int taille();
	
	public int val();
}
