package model;

public class Ficha {
	
	//Los puntos que tiene el dominó en cada lado
	//cambiar todo a private luego
	public int ptosArriba;
	public int ptosAbajo;
	
	public Ficha(int ptosArriba, int ptosAbajo) {
		this.ptosAbajo = ptosAbajo;
		this.ptosArriba = ptosArriba;
		
	}
	
	public int getPtosArriba()
	{
		return ptosArriba;
	}
	
	public int getPtosAbajo()
	{
		return ptosAbajo;
	}
	
	public String getUnicode(int valor) {
		if (valor == 0) {
			return "0"; 
		}
		else if (valor == 1) {
			return "1";
		}
		else if (valor == 2) {
			return "2";
		}
		else if (valor == 3) {
			return "3";
		}
		else if (valor == 4) {
			return "3";
		}
		else if (valor == 5) {
			return "5";
		}
		else {
			return "6";
		}
		
		
	}
	
	public String imprimirFicha()

	{
		return this.getUnicode(ptosAbajo)+this.getUnicode(ptosArriba)+"  ";
	}
	
}
