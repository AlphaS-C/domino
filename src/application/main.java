package Aplicacion;



import model.*;
import java.util.Random;
import java.util.Scanner; 

public class main {

	public static void main(String[] args) {
		Mesa juego = new Mesa();
		Jugador jugador1 = new Jugador(juego);
		Jugador jugador2 = new Jugador(juego);
		Random aleatorio = new Random();
		int num;
		Ficha fichaAPoner;
		boolean bandera;
		boolean noCome = false;
		Scanner entrada = new Scanner(System.in);
		System.out.println(jugador1.getNumJugador());
		System.out.println(jugador2.getNumJugador());
		juego.repartir(jugador1);
		juego.repartir(jugador2);
		jugador1.imprimirFichas();
		int turno = 2;
		
		
		int indiceMayorD = juego.hallarMayorDoble(jugador1, jugador2);
		
		if(indiceMayorD == 1000)
		{
			juego.mesa.add(jugador1.fichas.get(0));
			System.out.println("Ninguno tiene doble");
			System.out.println("El jugador 1 empieza");
			jugador1.fichas.remove(0);
			
		}
		else {
			if(indiceMayorD>=0)
			{
				juego.mesa.add(jugador1.fichas.get(indiceMayorD));
				juego.cola = jugador1.fichas.get(indiceMayorD).ptosAbajo;
				juego.cabeza = jugador1.fichas.get(indiceMayorD).ptosArriba;
				System.out.println("El jugador 1 empieza");
				System.out.println(jugador1.fichas.get(indiceMayorD).imprimirFicha());
				jugador1.fichas.remove(indiceMayorD);
				jugador1.imprimirFichas();
				
				

			}
			else 
			{
				juego.mesa.add(jugador2.fichas.get(-indiceMayorD-1));
				juego.cola = jugador2.fichas.get(-indiceMayorD-1).ptosAbajo;
				juego.cabeza = jugador2.fichas.get(-indiceMayorD-1).ptosArriba;
				System.out.println("El jugador 2 empieza");
				System.out.println(jugador2.fichas.get(-indiceMayorD-1).imprimirFicha());
				jugador2.fichas.remove(-indiceMayorD-1);
				turno=1;
				
				
			}
		}
		

		while( jugador1.fichas.size()*jugador2.fichas.size() > 0) {

			if(turno == 2)
			{
				
				jugador2.comerVarias();
				for(int i=0;i<jugador2.fichas.size();i++)
				{
					
					String posicionesVal = jugador2.posicionesPosibles(i);
					if(posicionesVal.length()>0) {
						System.out.println("\nel jugador 2 pone "+jugador2.fichas.get(i).imprimirFicha());
						jugador2.ponerFicha(i, posicionesVal.charAt(0));
						turno = 1;
						juego.imprimirMesa();
						break;
					}
					
					
				}
				
			}
			
			else if(turno==1)
			{
				jugador1.comerVarias();
				

				
				int ind = entrada.nextInt();
				String  posicionesVal = jugador1.posicionesPosibles(ind);
				
				
				if(posicionesVal.length() >0)
				{
					turno =2;
					String lado = posicionesVal;
					if(posicionesVal.length() == 2)
					{
						System.out.println("En que lado desea poner la ficha(i/d)");
						lado = entrada.next();
					}
					jugador1.ponerFicha(ind, lado.charAt(0));

					jugador1.imprimirFichas();
					juego.imprimirMesa();
					
				}
				else {
					System.out.println("Movimiento no valido, intente de nuevo");
				}
			}
			
		}
		
		if(jugador1.fichas.size() == 0)
		{
			System.out.println("\ngana el jugador 1");
		}
		else
		{
			System.out.println("\ngana el jugador 2");
		}
		
		System.out.println("final del juego");
		
	}

}
