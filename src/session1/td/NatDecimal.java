package session1.td;

public class NatDecimal implements Nat {
	
	private String chiffres;
	
	public static final FabriqueNat<Nat> FAB = new NatDecimal("");
	
	private static final Nat DIX = FAB.creerNatAvecRepresentation("10");
	
	private NatDecimal(String s) {
		this.chiffres = s;
	}
	
	private static void nettoyer(StringBuilder sb) {
		int zeros = 0;
		while(zeros < sb.length() && sb.charAt(zeros) == '0')
			zeros++;
		sb.delete(0, zeros);
	}

	@Override
	public Nat creerNatAvecValeur(int i) {
		// TODO Auto-generated method stub
		return new NatDecimal(String.valueOf(i));
	}

	@Override
	public Nat creerZero() {
		// TODO Auto-generated method stub
		return this.creerNatAvecRepresentation("0");
	}

	@Override
	public Nat creerSuccesseur(Nat elt) {
		// TODO Auto-generated method stub
		int t = elt.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = 1;
		for(int i = 0; i < t; i++){
			int chiffre = elt.chiffre(i) + retenue;
			if(chiffre > 9){
				chiffre = chiffre - 10;
				retenue = 1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}

	@Override
	public Nat creerNatAvecRepresentation(String s) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(s);
		nettoyer(sb);
		String nb = new String(sb);
		if(!nb.matches("\\d*"))
			throw new IllegalArgumentException("Ce n'est pas un nombre");
		else if(nb.equals(""))
			return new NatDecimal("0");
		else
			return new NatDecimal(nb);
	}

	@Override
	public Nat somme(Nat x) {
		// TODO Auto-generated method stub
		int t = this.taille() < x.taille() ? x.taille() : this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = 0;
		for(int i = 0; i < t; i++){
			int chiffre = this.chiffre(i) + x.chiffre(i) + retenue;
			if(chiffre > 9){
				chiffre = chiffre - 10;
				retenue = 1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}

	@Override
	public Nat zero() {
		// TODO Auto-generated method stub
		return this.creerZero();
	}

	@Override
	public Nat produit(Nat x) {
		// TODO Auto-generated method stub
		if(x.equals(DIX))
			return this.creerNatAvecRepresentation(this.toString().concat("0"));
		else {
			Nat index = this.creerZero();
			Nat ret = this.creerZero();
			while(!index.equals(x)) {
				ret = ret.somme(this);
				index = this.creerSuccesseur(index);
			}
			return ret;
		}
	}

	@Override
	public Nat un() {
		// TODO Auto-generated method stub
		return this.creerNatAvecRepresentation("1");
	}

	@Override
	public Nat modulo(Nat x) {
		// TODO Auto-generated method stub
		if(x.equals(DIX)) 
			return this.creerNatAvecRepresentation(String.valueOf(this.chiffre(0)));
		else {
			Nat reste = zero();
			Nat num = zero();
			while(!num.equals(this)){
				reste = this.creerSuccesseur(reste);
				num = num.creerSuccesseur(num);
				if(reste.equals(x))
					reste = zero();
			}
			return reste;
		}
	}

	@Override
	public Nat div(Nat x) {
		// TODO Auto-generated method stub
		if(x.equals(DIX)) 
			if(this.taille() == 1)
				return this.creerNatAvecRepresentation("0");
			else
				return this.creerNatAvecRepresentation(this.toString().substring(0,this.taille() - 1));
		else {
			Nat reste = zero();
			Nat num = zero();
			Nat val = zero();
			while(!num.equals(this)){
				reste = this.creerSuccesseur(reste);
				num = num.creerSuccesseur(num);
				if(reste.equals(x)) {
					reste = zero();
					val = this.creerSuccesseur(val);
				}
			}
			return val;
		}
	}

	@Override
	public boolean estNul() {
		// TODO Auto-generated method stub
		int t = this.taille();
		for(int i = 0; i < t; i++){
			if(this.chiffre(i) != 0)
				return false;
		}
		return true;
	}

	@Override
	public Nat predecesseur() {
		// TODO Auto-generated method stub
		int t = this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = - 1;
		for(int i = 0; i < t; i++){
			int chiffre = this.chiffre(i) + retenue;
			if(chiffre > 9){
				chiffre = chiffre - 10;
				retenue = 1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}

	@Override
	public int chiffre(int i) {
		// TODO Auto-generated method stub
		if(i >= this.taille())
			return 0;
		else
			return Character.getNumericValue(this.toString().charAt(this.taille() -1 - i));
	}

	@Override
	public int taille() {
		// TODO Auto-generated method stub
		return this.toString().length();
	}

	@Override
	public int val() {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.chiffres);
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
