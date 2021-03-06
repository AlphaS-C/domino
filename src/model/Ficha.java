package model;

public class Ficha {

	private int ptosArriba;
	private int ptosAbajo;

	public Ficha(int ptosArriba, int ptosAbajo) {
		this.ptosAbajo = ptosAbajo;
		this.ptosArriba = ptosArriba;

	}

	public int getPtosArriba() {
		return ptosArriba;
	}

	public int getPtosAbajo() {
		return ptosAbajo;
	}

	public String getUnicode(int valor) {
		if (valor == 0) {
			return "0";
		} else if (valor == 1) {
			return "1";
		} else if (valor == 2) {
			return "2";
		} else if (valor == 3) {
			return "3";
		} else if (valor == 4) {
			return "4";
		} else if (valor == 5) {
			return "5";
		} else {
			return "6";
		}

	}

	public String imprimirFicha()

	{
		return this.getUnicode(ptosArriba) + this.getUnicode(ptosAbajo) + "  ";
	}

}
