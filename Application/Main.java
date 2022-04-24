package Aplicacion;



import model.*;
import java.util.Random; 

public class main {

	public static void main(String[] args) {
		Domino juego = new Domino();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Random aleatorio = new Random();
		
		juego.repartir(jugador1);
		juego.repartir(jugador2);
		System.out.print("Jugador 1: ");
		jugador1.imprimirFichas();
		System.out.println();
		System.out.print("Jugador 2: ");
		jugador2.imprimirFichas();
		int turno = 2;
		
		
		int indiceMayorD = juego.hallarMayorDoble(jugador1, jugador2);
		
		if(indiceMayorD == 1000)
		{
			System.out.println("Ninguno tiene doble");
			System.out.println("El jugador 1 empieza");
			jugador1.fichas.remove(0);
		}
		else {
			if(indiceMayorD>=0)
			{
				System.out.println();
				System.out.println("El jugador 1 empieza");
				jugador1.fichas.remove(indiceMayorD);
				
				

			}
			else 
			{
				System.out.println();
				System.out.println("El jugador 2 empieza");
				jugador2.fichas.remove(-indiceMayorD-1);
				turno=1;
				
				
			}
		}
		
		System.out.print("Jugador 2: ");
		jugador2.imprimirFichas();
		System.out.println();
		System.out.print("Jugador 1: ");
		jugador1.imprimirFichas();
		while( jugador1.fichas.size()*jugador2.fichas.size() > 0) {
			if(turno == 2)
			{
				jugador2.fichas.remove(aleatorio.nextInt(jugador1.fichas.size()));
				turno = 1;
			}
			else
			{
				jugador1.preguntarMovimiento();
				turno = 2;
			}
			System.out.println();
			System.out.print("Jugador 2: ");
			jugador2.imprimirFichas();
			System.out.println();
			System.out.print("Jugador 1: ");
			jugador1.imprimirFichas();
		}
		
		System.out.println("final del juego");
		
	}

}
