package session1.td;

public class Test {

	public static void main(String args[]) {
		test(NatParInt.FAB);
		test(Zero.FAB);
		test(Succ.FAB);
		test(NatDecimal.FAB);
		test(ZeroRec.FAB);
		test(SuccRec.FAB);
	}
	
	public static void test(FabriqueNat<Nat> fab) {
		System.out.println("************************************************");
		System.out.println(fab.getClass());
		System.out.println("************************************************");
		Nat zero = fab.creerZero();
		System.out.println("0 ? " + zero.toString());
		System.out.println("true ? " + zero.equals(zero.zero()));
		Nat un = fab.creerSuccesseur(zero);
		System.out.println("1 ? " + un.toString());
		System.out.println("true ? " + un.equals(un.un()));
		Nat predUn = un.predecesseur();
		System.out.println("0 ? " + predUn.toString());
		Nat cinq = fab.creerNatAvecValeur(5);
		System.out.println("5 ? " + cinq.toString());
		System.out.println("4 ? " + cinq.predecesseur().toString());
		Nat six = fab.creerNatAvecRepresentation("6");
		System.out.println("6 ? " + six.toString());
		System.out.println("11 ? " + cinq.somme(six).toString());
		System.out.println("30 ? " + cinq.produit(six).toString());
		System.out.println("5 ? " + fab.creerNatAvecValeur(33).div(six).toString());
		System.out.println("3 ? " + fab.creerNatAvecValeur(33).modulo(six).toString());
		//StackOverflowException
		//Nat deuxM = fab.creerNatAvecValeur(2_000_000_000);
		//System.out.println("4_000_000_000 ? " + deuxM.somme(deuxM).toString());
		System.out.println("************************************************");
	}
}
