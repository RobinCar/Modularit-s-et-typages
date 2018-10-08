package session1.td;

public class Succ implements Nat {
	
	public static final FabriqueNat<Nat> FAB = new Succ(Zero.FAB.creerZero());
	
	private Nat pred;
	
	public Succ(Nat predecesseur) {
		if(predecesseur == null)
			throw new NullPointerException("L'argument ne peut pas être nul");
		this.pred = predecesseur;
	}

	@Override
	public Nat creerNatAvecValeur(int i) {
		// TODO Auto-generated method stub
		if(i == 0)
			return new Zero();
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
		return this.creerZero();
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
		if(this.val() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Nat predecesseur() {
		// TODO Auto-generated method stub
		return this.pred;
	}

	@Override
	public int chiffre(int i) {
		// TODO Auto-generated method stub
		return (i == 0) ? this.val()%10 : this.creerNatAvecValeur(this.val() / 10).chiffre(i - 1);
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		return (this.val() < 10) ? 1 : 1 + this.creerNatAvecValeur(this.val() / 10).taille();
	}

	@Override
	public int val() {
		// TODO Auto-generated method stub
		return this.predecesseur().val() + 1;
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
