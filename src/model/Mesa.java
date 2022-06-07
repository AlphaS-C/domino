package model;

import java.util.ArrayList;
import java.util.Random;

public class Mesa {
	private ArrayList<Ficha> baraja;
	private ArrayList<Ficha> mesa;
	private int cabeza;
	private int cola;

	public Mesa() {
		setMesa(new ArrayList<Ficha>());
		baraja = new ArrayList<Ficha>();

		for (int i = 0; i < 7; i++) {
			for (int j = i; j < 7; j++) {
				baraja.add(new Ficha(i, j));
			}
		}
	}

	public int hallarMayorDoble(Jugador jugador1, Jugador jugador2) {
		int mayor = -1;
		int indice = 1000;
		Ficha fichaj1;
		Ficha fichaj2;
		for (int i = 0; i < jugador1.fichas.size(); i++) {
			fichaj1 = jugador1.fichas.get(i);
			if (fichaj1.getPtosAbajo() == fichaj1.getPtosArriba() && fichaj1.getPtosAbajo() > mayor) {
				mayor = fichaj1.getPtosAbajo();
				indice = i;

			}
		}
		for (int i = 0; i < jugador2.fichas.size(); i++) {
			fichaj2 = jugador2.fichas.get(i);
			if (fichaj2.getPtosAbajo() == fichaj2.getPtosArriba() && fichaj2.getPtosAbajo() > mayor) {
				mayor = fichaj2.getPtosAbajo();
				// Si pertenece al jugador 2 lo tomamos como negativo
				// y asi sabremos que pertenece a el
				indice = -i - 1;

			}
		}
		return indice;
	}

	public void repartir(Jugador jugador) {
		int numeroFicha;
		Random rand = new Random();
		int tamanioBaraja = baraja.size();
		for (int f = tamanioBaraja; f > tamanioBaraja - 7; f--) {
			numeroFicha = rand.nextInt(f);
			jugador.fichas.add(baraja.get(numeroFicha));
			baraja.remove(numeroFicha);
		}
	}

	public void imprimirMesa() {
		System.out.print("Mesa: ");
		for (int i = 0; i < getMesa().size(); i++) {
			System.out.print(getMesa().get(i).imprimirFicha());
		}
	}

	public ArrayList<Ficha> getMesa() {
		return mesa;
	}

	public ArrayList<Ficha> getBaraja() {
		return baraja;
	}

	public void setMesa(ArrayList<Ficha> mesa) {
		this.mesa = mesa;
	}

	public int getCola() {
		return cola;
	}

	public void setCola(int cola) {
		this.cola = cola;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}
}
