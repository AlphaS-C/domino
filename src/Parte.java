
public class Parte {

	
	int valor;

	public Parte(int valor) {
		super();
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public String getUnicode() {
		if (valor == 0) {
			return "☐"; 
		}
		else if (valor == 1) {
			return "\u2680";
		}
		else if (valor == 2) {
			return "\u2681";
		}
		else if (valor == 3) {
			return "\u2682";
		}
		else if (valor == 4) {
			return "\u2683";
		}
		else if (valor == 5) {
			return "\u2684";
		}
		else {
			return "\u2685";
		}
		
		
	}
	
	
	
	
}
