package session1.td;

public class NatParInt implements Nat {
	
	public static final FabriqueNat<Nat> FAB = new NatParInt(0);
	
	private int val;
	
	public NatParInt(int i) {
		if(val < 0)
			throw new IllegalArgumentException("Int négatif");
		this.val = i;
	}

	@Override
	public Nat creerNatAvecValeur(int i) {
		// TODO Auto-generated method stub
		return new NatParInt(i);
	}

	@Override
	public Nat creerZero() {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(0);
	}

	@Override
	public Nat creerSuccesseur(Nat elt) {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(elt.val() + 1);
	}

	@Override
	public Nat creerNatAvecRepresentation(String s) {
		// TODO Auto-generated method stub
		if(!s.matches("\\d*"))
			throw new IllegalArgumentException("Ce n'est pas un nombre");
		else if(s.equals(""))
			return this.creerNatAvecValeur(0);
		else
			return this.creerNatAvecValeur(Integer.parseInt(s));
	}

	@Override
	public Nat somme(Nat x) {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(this.val() + x.val());
	}

	@Override
	public Nat zero() {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(0);
	}

	@Override
	public Nat produit(Nat x) {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	@Override
	public Nat un() {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(1);
	}

	@Override
	public boolean estNul() {
		// TODO Auto-generated method stub
		if(val == 0) 
			return true;
		else 
			return false;
	}

	@Override
	public Nat predecesseur() {
		if(this.estNul()) 
			throw new UnsupportedOperationException("Pas de prédécesseur");
		return this.creerNatAvecValeur(this.val() - 1);
	}

	@Override
	public int chiffre(int i) {
		// TODO Auto-generated method stub
		return (i == 0) ? this.val()%10 : this.creerNatAvecValeur(this.val() / 10).chiffre(i - 1);
	}

	@Override
	public int taille() {
		return (this.val() < 10) ? 1 : 1 + this.creerNatAvecValeur(this.val() / 10).taille();
	}

	@Override
	public int val() {
		// TODO Auto-generated method stub
		return this.val;
	}
	
	@Override
	public Nat modulo(Nat x) {
		return this.creerNatAvecValeur(this.val() % x.val());
	}
	
	@Override
	public Nat div(Nat x) {
		return this.creerNatAvecValeur(this.val() / x.val());
	}
	
	public String toString() {
		return String.valueOf(this.val());
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Nat)) {
			return false;
		}
		Nat x = (Nat)o;
		if(x.val() == this.val())
			return true;
		else
			return false;
	}

}
