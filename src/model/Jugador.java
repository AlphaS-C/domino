package model;

import java.util.ArrayList;

public class Jugador {

	public ArrayList<Ficha> fichas;
	private int numeroJugador;
	private static int cantJugadores = 1;
	Mesa juego;

	public Jugador(Mesa juego) {
		this.fichas = new ArrayList<Ficha>();
		this.numeroJugador = cantJugadores;
		this.juego = juego;
		cantJugadores++;
	}

	public boolean puedePoner() {
		for (int i = 0; i < fichas.size(); i++) {
			if (this.posicionesPosibles(i).length() > 0) {
				return true;
			}
		}

		return false;
	}

	public String posicionesPosibles(int i) {
		String posiciones = "";
		if (i < 0 || i >= fichas.size()) {
			return posiciones;
		}

		Ficha fichaAPoner = this.fichas.get(i);
		if (fichaAPoner.getPtosAbajo() == juego.getCola() || fichaAPoner.getPtosArriba() == juego.getCola()) {
			posiciones += "i";
		} else if (fichaAPoner.getPtosAbajo() == juego.getCabeza()
				|| fichaAPoner.getPtosArriba() == juego.getCabeza()) {
			posiciones += "d";
		}

		return posiciones;

	}

	public void ponerFicha(int i, char lado) {
		Ficha fichaAPoner = this.fichas.get(i);
		if (lado == 'i') {
			juego.getMesa().add(0, new Ficha(fichaAPoner.getPtosAbajo() + fichaAPoner.getPtosArriba() - juego.getCola(),
					juego.getCola()));
			juego.setCola(fichaAPoner.getPtosAbajo() + fichaAPoner.getPtosArriba() - juego.getCola());
		}

		else if (lado == 'd') {
			juego.getMesa().add(new Ficha(juego.getCabeza(),
					fichaAPoner.getPtosAbajo() + fichaAPoner.getPtosArriba() - juego.getCabeza()));
			juego.setCabeza(fichaAPoner.getPtosAbajo() + fichaAPoner.getPtosArriba() - juego.getCabeza());
		}

		this.fichas.remove(i);
	}

	public ArrayList<Ficha> getFichas() {
		return fichas;
	}

	public int calcularPuntaje() {
		int puntaje = 0;
		for (int i = 0; i < fichas.size(); i++) {
			puntaje += fichas.get(i).getPtosAbajo() + fichas.get(i).getPtosArriba();
		}

		return puntaje;
	}

	public void imprimirFichas() {
		System.out.print("\njugador " + this.numeroJugador + ": ");
		for (int i = 0; i < fichas.size(); i++) {
			System.out.print(fichas.get(i).imprimirFicha());
		}
		System.out.println();
	}

	public int getNumJugador() {
		return numeroJugador;
	}
}
