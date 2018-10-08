package session1.demo1.v1;

public class NatParInt {
	
	private int val;
	
	public int getVal() {
		return val;
	}

	public NatParInt(int i) {
		if(i < 0){
			throw new IllegalArgumentException("int négatif");
		}
		this.val = i;
	}
}
