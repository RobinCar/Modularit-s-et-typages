package session1.td;

public interface FabriqueNat<T> {
	
	public T creerNatAvecValeur(int i);
	
	public T creerZero();
	
	public T creerSuccesseur(T elt);
	
	public T creerNatAvecRepresentation(String s);
}
