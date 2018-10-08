package session1.td;

public class Zero implements Nat {
	
	public static final FabriqueNat<Nat> FAB = new Zero();

	@Override
	public Nat creerNatAvecValeur(int i) {
		// TODO Auto-generated method stub
		if(i == 0)
			return this.creerZero();
		else
			return this.creerSuccesseur(this.creerNatAvecValeur(i - 1));
	}

	@Override
	public Nat creerZero() {
		// TODO Auto-generated method stub
		return new Zero();
	}

	@Override
	public Nat creerSuccesseur(Nat elt) {
		// TODO Auto-generated method stub
		return new Succ(elt);
	}

	@Override
	public Nat creerNatAvecRepresentation(String s) {
		// TODO Auto-generated method stub
		if(!s.matches("\\d*"))
			throw new IllegalArgumentException("Ce n'est pas un nombre");
		else if(s.equals(""))
			return this.creerZero();
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
	public Nat modulo(Nat x) {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(this.val() % x.val());
	}

	@Override
	public Nat div(Nat x) {
		// TODO Auto-generated method stub
		return this.creerNatAvecValeur(this.val() / x.val());
	}

	@Override
	public boolean estNul() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Nat predecesseur() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Pas de prédécesseur");
	}

	@Override
	public int chiffre(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int val() {
		// TODO Auto-generated method stub
		return 0;
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
