package controller;

import model.Jugador;
import model.Maquina;
import model.Mesa;

public class ControladorMesa {

	private Jugador jugador1;
	private Maquina jugador2;

	private int bandera = 0;
	private int indice;
	private int turno = 2;

	public void inicializar(Mesa mesa) {
		this.jugador1 = new Jugador(mesa);
		this.jugador2 = new Maquina(mesa);
		mesa.repartir(jugador1);
		mesa.repartir(jugador2);

		int indiceMayorD = mesa.hallarMayorDoble(jugador1, jugador2);

		if (indiceMayorD == 1000) {
			mesa.getMesa().add(jugador1.fichas.get(0));
			System.out.println("Ninguno tiene doble");
			System.out.println("El jugador 1 empieza");
			jugador1.fichas.remove(0);

		} else {
			if (indiceMayorD >= 0) {
				mesa.getMesa().add(jugador1.fichas.get(indiceMayorD));
				mesa.setCola(jugador1.fichas.get(indiceMayorD).getPtosAbajo());
				mesa.setCabeza(jugador1.fichas.get(indiceMayorD).getPtosArriba());
				System.out.println("El jugador 1 empieza");
				System.out.println(jugador1.fichas.get(indiceMayorD).imprimirFicha());
				jugador1.fichas.remove(indiceMayorD);
				jugador1.imprimirFichas();
			} else {
				mesa.getMesa().add(jugador2.fichas.get(-indiceMayorD - 1));
				mesa.setCola(jugador2.fichas.get(-indiceMayorD - 1).getPtosAbajo());
				mesa.setCabeza(jugador2.fichas.get(-indiceMayorD - 1).getPtosArriba());
				System.out.println("El jugador 2 empieza");
				System.out.println(jugador2.fichas.get(-indiceMayorD - 1).imprimirFicha());
				jugador2.fichas.remove(-indiceMayorD - 1);
				turno = 1;
			}
		}
	}

	public void turno(Mesa mesa, int ind) {

		if (turno == 2) {

			if (jugador2.puedePoner()) {
				indice = jugador2.sacarMasOptima();

				System.out.println("\nel jugador 2 pone " + jugador2.fichas.get(indice).imprimirFicha());
				jugador2.ponerFicha(indice, jugador2.posicionesPosibles(indice).charAt(0));
				turno = 1;
				mesa.imprimirMesa();
				bandera = 0;
			} else {
				bandera += 1;
				System.out.println("\nno puede poner ficha jugador 2");
				turno = 1;
			}

			turno = 1;
		}

		else if (turno == 1) {
			if (jugador1.puedePoner()) {
				String posicionesVal = jugador1.posicionesPosibles(ind);
				if (posicionesVal.length() > 0) {
					turno = 2;
					String lado = posicionesVal;
					if (posicionesVal.length() > 1) {
						System.out.println("En que lado desea poner la ficha(i/d)");
					}
					jugador1.ponerFicha(ind, lado.charAt(0));

					jugador1.imprimirFichas();
					mesa.imprimirMesa();
					bandera = 0;
				} else {
					System.out.println("Movimiento no valido, intente de nuevo");
				}
			} else {
				bandera += 1;
				System.out.println("\nno puede poner ficha jugador 1");
				turno = 2;
			}
		}

	}

	public String returnGanador() {
		String ganador = "";
		if (jugador1.calcularPuntaje() < jugador2.calcularPuntaje()) {
			ganador = "El ganador es el jugador 1";
		} else if (jugador1.calcularPuntaje() > jugador2.calcularPuntaje()) {
			ganador = "El ganador es el jugador 2";
		} else {
			if (turno == 1) {
				ganador = "El ganador es el jugador 2";
			} else if (turno == 2) {
				ganador = "El ganador es el jugador 1";
			}
		}
		return ganador;

	}

	public int getTurno() {
		return turno;
	}

	public Jugador getJugador() {
		return jugador1;
	}

	public Maquina getMaquina() {
		return jugador2;
	}

	public int getBandera() {
		return bandera;
	}

	public void setBandera(int i) {
		this.bandera = i;
	}

}
