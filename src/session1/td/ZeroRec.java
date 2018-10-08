package session1.td;

public class ZeroRec extends Zero implements Nat {
	
	public static final FabriqueNat<Nat> FAB = new ZeroRec();
	
	public Nat creerSuccesseur(Nat pred) {
		return new SuccRec(pred);
	}
	
	public Nat zero() {
		return this.creerZero();
	}
	
	public Nat un() {
		return this.creerSuccesseur(this.creerZero());
	}
	
	public Nat somme(Nat x) {
		return x;
	}
	
	public Nat produit(Nat x) {
		return this.creerZero();
	}
	
	public Nat modulo(Nat x) {
		return this.creerZero();
	}
	
	public Nat div(Nat x) {
		return this.creerZero();
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
