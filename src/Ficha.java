
public class Ficha {

	
	private Parte lado1;
	private Parte lado2;
	
	
	public Ficha(Parte lado1, Parte lado2) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public String toString() {
		
		return "" + this.lado1.getUnicode() + this.lado2.getUnicode();
		 
	}
	
	
}
