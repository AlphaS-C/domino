package model;

import java.util.ArrayList;
import java.util.Random;

public class Domino {
	public ArrayList<Ficha> baraja;
	public ArrayList<Ficha> mesa;
	public String cabeza;
	public String cola;
	
	public Domino()
	{
		baraja = new ArrayList<Ficha>();
		
		for(int i=0; i<7; i++)
		{
			for(int j=i; j<7; j++)
			{
				baraja.add(new Ficha(i,j));
			}
		}
	}
	
	public int hallarMayorDoble(Jugador jugador1, Jugador jugador2)
	{
		int mayor=-1;
		int indice=1000;
		Ficha fichaj1; Ficha fichaj2;
		for(int i=0; i<jugador1.fichas.size(); i++)
		{
			fichaj1 = jugador1.fichas.get(i);
			if(fichaj1.ptosAbajo == fichaj1.ptosArriba && fichaj1.ptosAbajo >mayor)
			{
				mayor = fichaj1.ptosAbajo;
				indice = i;
				
			}
		}
		for(int i=0; i<jugador2.fichas.size(); i++)
		{
			fichaj2 = jugador2.fichas.get(i);
			if(fichaj2.ptosAbajo == fichaj2.ptosArriba && fichaj2.ptosAbajo >mayor)
			{
				mayor = fichaj2.ptosAbajo;
				//Si pertenece al jugador 2 lo tomamos como negativo
				//y asi sabremos que pertenece a el
				indice = -i-1;
				
			}
		}
		return indice;
	}
	
	public void repartir(Jugador jugador) {
		int numeroFicha;
		Random rand = new Random();
		int tamanioBaraja = baraja.size();
		for(int f=tamanioBaraja; f>tamanioBaraja-7; f--)
		{
			numeroFicha = rand.nextInt(f);
			jugador.fichas.add(baraja.get(numeroFicha));
			baraja.remove(numeroFicha);
		}
	}
	
	public void imprimirMesa()
	{
		for(int i=0; i<mesa.size(); i++)
		{
			System.out.print(mesa.get(i).imprimirFicha());
		}
	}
}
