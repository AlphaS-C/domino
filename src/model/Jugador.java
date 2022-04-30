package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
	
	public ArrayList<Ficha> fichas;
	private Scanner entrada;
	private int numeroJugador;
	private static int cantJugadores = 1;
	Mesa juego;
	
	public Jugador(Mesa juego) {
		this.fichas = new ArrayList<Ficha>();
		this.numeroJugador = cantJugadores;
		this.juego = juego;
		cantJugadores++;
	}
		
	
	public String posicionesPosibles(int i)
	{
		String posiciones = "";
		if(i<0 || i>=fichas.size())
		{	
			return posiciones;
		}
		
		Ficha fichaAPoner = this.fichas.get(i);
		if(fichaAPoner.ptosAbajo == juego.cola || fichaAPoner.ptosArriba == juego.cola) {
			posiciones+="i";
		}
		else if(fichaAPoner.ptosAbajo == juego.cabeza || fichaAPoner.ptosArriba == juego.cabeza) {
			posiciones+="d";
		}
		
		return posiciones;
		
		
		
		
	}
	
	
	

	public void ponerFicha(int i, char lado)
	{
		Ficha fichaAPoner = this.fichas.get(i);
		if(lado == 'i') {
			juego.mesa.add(0, new Ficha(fichaAPoner.ptosAbajo+fichaAPoner.ptosArriba-juego.cola, juego.cola));
			juego.cola = fichaAPoner.ptosAbajo+fichaAPoner.ptosArriba-juego.cola;
		}
		
		else if(lado == 'd') {
			juego.mesa.add(new Ficha(juego.cabeza, fichaAPoner.ptosAbajo+fichaAPoner.ptosArriba-juego.cabeza));
			juego.cabeza = fichaAPoner.ptosAbajo+fichaAPoner.ptosArriba-juego.cabeza;
		}
		
		this.fichas.remove(i);
	}
	
	
	
	
	
	public void comerFicha() {
			this.fichas.add(juego.baraja.get(0));
			juego.baraja.remove(0);
	}
	

	public boolean puedePoner()
	{
		for(int i=0; i<fichas.size(); i++) {
			if(this.posicionesPosibles(i).length()>0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void comerVarias()
	{
		int comidas = 0;
		while(juego.baraja.size()>0) {
			if(!puedePoner())
			{
				this.comerFicha();
				comidas++;
			}
			else {
				break;
			}
		}
		if(comidas>0)
		{
			System.out.println("\nel jugador "+numeroJugador+" come "+comidas+" fichas");
			if(numeroJugador == 1)
			{
				imprimirFichas();
				juego.imprimirMesa();
			}
		}
		
	}
	
	public void imprimirFichas()
	{
		System.out.print("\njugador "+this.numeroJugador+": ");
		for(int i=0; i<fichas.size(); i++)
		{
			System.out.print(fichas.get(i).imprimirFicha());
		}
		System.out.println();
	}
	
	public int getNumJugador()
	{
		return numeroJugador;
		}
}




