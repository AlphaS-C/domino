package model;

import java.util.ArrayList;

public class Maquina extends Jugador{
	ArrayList<Integer> fichasJugables;
	ArrayList<Integer> puntajes;
	Ficha ficha;
	
	public Maquina(Mesa juego)
	{
		super(juego);
	}
	public ArrayList<Integer> tomarFichasJugables()
	{
		fichasJugables = new ArrayList<Integer>();
		for(int i=0; i<this.fichas.size(); i++)
		{
			if(posicionesPosibles(i).length() > 0)
			{
				fichasJugables.add(i);
			}
		}
		
		return fichasJugables;
	}
	
	public int calcularRepetidas(int valor)
	{
		int repetidas = 0;
		for(int i=0; i<fichas.size(); i++)
		{
			if(fichas.get(i).ptosArriba == valor || fichas.get(i).ptosAbajo == valor)
			{
				repetidas+=1;
			}
		}
		
		return repetidas;
	}
	
	public int calcularPuntaje(Ficha ficha)
	{
		int puntaje = 0; 
		if(ficha.ptosAbajo == ficha.ptosArriba)
		{
			puntaje+=1;
		}
		
		if(ficha.ptosAbajo+ficha.ptosArriba > 6)
		{
			puntaje+=1;
		}
		
		if (calcularRepetidas(ficha.ptosAbajo) == 1)
		{
			puntaje-=2;
		}
		
		if(calcularRepetidas(ficha.ptosArriba) == 1) 
		{
			puntaje-=2;
		}
		
		return puntaje;
		
		
	}
	
	public int sacarMasOptima()
	{
		ArrayList<Integer> fichasPosibles= tomarFichasJugables();
		int indice =0; int maxPuntaje = -5; int indiceFicha; int puntajeFicha;
		for(int i=0; i<fichasPosibles.size(); i++)
		{
			indiceFicha = fichasPosibles.get(i); 
			puntajeFicha = calcularPuntaje(fichas.get(indiceFicha));
			if(puntajeFicha > maxPuntaje)
			{
				indice = indiceFicha;
				maxPuntaje = puntajeFicha; 
			}
		}
		
		//this.ponerFicha(indice, posicionesPosibles(indice).charAt(0));
		return indice;
	}
}
