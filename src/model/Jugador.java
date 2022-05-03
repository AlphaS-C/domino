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
	
	
	
	
	
	
	

	
	
	
	public int calcularPuntaje()
	{
		int puntaje=0;
		for(int i=0; i<fichas.size(); i++)
		{
			puntaje+=fichas.get(i).ptosAbajo+fichas.get(i).ptosArriba;
		}
		
		return puntaje;
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




