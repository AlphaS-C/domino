package aplicacion;

import controller.*;

import model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage; 

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		Scene scene;
		Mesa mesa = new Mesa();
		ControladorMesa controller = new ControladorMesa();
		MainView mainView = new MainView();

		scene = new Scene(mainView,800,800);
		stage.setScene(scene);
		stage.show();

		inicializar(mesa, controller, mainView);
		mainView.drawText("Para jugar pulsa la tecla numerica que corresponda",0, 1);
		mainView.drawText("con la ficha que quieres ubicar en el tablero",0, 2);
		
		scene.setOnKeyPressed(e -> {
			
			int ind;
		    if (e.getCode().isDigitKey()) {
		    	
		    	if (controller.getTurno() == 2) {
			    	controller.turno2(mesa, 0); 
					drawScreen(mesa, controller, mainView);

		    	}
		    	
		    	else if (e.getCode().isDigitKey()) {
		    		ind = Integer.parseInt(e.getCode().getName().replaceAll("[^0-9]", "")) - 1; // trukosky pa tomar el valor del teclado numerico como int
			    	controller.turno2(mesa, ind); 
					drawScreen(mesa, controller, mainView);
					
					new java.util.Timer().schedule( 
					        new java.util.TimerTask() {
					            @Override
					            public void run() {
							    	controller.turno2(mesa, 0); 
									drawScreen(mesa, controller, mainView);
					            }
					
					        }, 
					        1000 
					);
					
					
		    		
		    	}
		    	
			    
		    }
		});
		
	}
	
		public void drawScreen (Mesa mesa, ControladorMesa controller, MainView mainView) {
			mainView.drawHand(controller.getJugador());
			mainView.drawText("Turno del jugador " + controller.getTurno(), 0, 3);
			mainView.drawTable(mesa);
		}
	
	
		public void inicializar(Mesa mesa, ControladorMesa controller, MainView mainView) {
			
			controller.inicializar(mesa);
			drawScreen(mesa, controller, mainView);
		}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	/*
	public static void main(String[] args) { }
		
		Mesa juego = new Mesa();
		Jugador jugador1 = new Jugador(juego);
		Maquina jugador2 = new Maquina(juego);
		int bandera = 0; 
		int indice;
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
			juego.getMesa().add(jugador1.fichas.get(0));
			System.out.println("Ninguno tiene doble");
			System.out.println("El jugador 1 empieza");
			jugador1.fichas.remove(0);
			
		}
		else {
			if(indiceMayorD>=0)
			{
				juego.getMesa().add(jugador1.fichas.get(indiceMayorD));
				juego.setCola(jugador1.fichas.get(indiceMayorD).getPtosAbajo());
				juego.setCabeza(jugador1.fichas.get(indiceMayorD).getPtosArriba());
				System.out.println("El jugador 1 empieza");
				System.out.println(jugador1.fichas.get(indiceMayorD).imprimirFicha());
				jugador1.fichas.remove(indiceMayorD);
				jugador1.imprimirFichas();
				
				

			}
			else 
			{
				juego.getMesa().add(jugador2.fichas.get(-indiceMayorD-1));
				juego.setCola(jugador2.fichas.get(-indiceMayorD-1).getPtosAbajo());
				juego.setCabeza(jugador2.fichas.get(-indiceMayorD-1).getPtosArriba());
				System.out.println("El jugador 2 empieza");
				System.out.println(jugador2.fichas.get(-indiceMayorD-1).imprimirFicha());
				jugador2.fichas.remove(-indiceMayorD-1);
				turno=1;
				
				
			}
		}
		

		while( jugador1.fichas.size()*jugador2.fichas.size() > 0 && bandera < 2 ) {

			if(turno == 2)
			{
				
				if(jugador2.puedePoner()) {
					indice = jugador2.sacarMasOptima();
					
					System.out.println("\nel jugador 2 pone "+jugador2.fichas.get(indice).imprimirFicha());
					jugador2.ponerFicha(indice, jugador2.posicionesPosibles(indice).charAt(0));
					turno = 1;
					juego.imprimirMesa();
					bandera =0;
//					for(int i=0;i<jugador2.fichas.size();i++)
//					{
//
//						String posicionesVal = jugador2.posicionesPosibles(i);
//						if(posicionesVal.length()>0) {
//							System.out.println("\nel jugador 2 pone "+jugador2.fichas.get(i).imprimirFicha());
//							jugador2.ponerFicha(i, posicionesVal.charAt(0));
//							turno = 1;
//							juego.imprimirMesa();
//							bandera =0;
//							break;
//						}
//
//
//					}
			}
				else
				{
					bandera+=1;
					System.out.println("\nno puede poner ficha jugador 2");
					turno = 1;
				}
			
				turno = 1;
			}
			
			else if(turno==1)
			{
				if(jugador1.puedePoner()) {

					int ind = entrada.nextInt();
					String  posicionesVal = jugador1.posicionesPosibles(ind);


					if(posicionesVal.length() >0)
					{
						turno =2;
						String lado = posicionesVal;
						if(posicionesVal.length() > 1)
						{
							System.out.println("En que lado desea poner la ficha(i/d)");
							lado = entrada.next();
						}
						jugador1.ponerFicha(ind, lado.charAt(0));

						jugador1.imprimirFichas();
						juego.imprimirMesa();
						bandera=0;

					}
					else {
						System.out.println("Movimiento no valido, intente de nuevo");
					}
				}
				else 
				{
					bandera+=1;
					System.out.println("\nno puede poner ficha jugador 1");
					turno = 2;
				}
			}
			
		}
		
		System.out.println("\npuntaje jugador 1: "+jugador1.calcularPuntaje());
		System.out.println("\npuntaje jugador 2: "+jugador2.calcularPuntaje());
		
		if(jugador1.calcularPuntaje() < jugador2.calcularPuntaje())
		{
			System.out.println("\ngana el jugador 1");
		}
		else if (jugador1.calcularPuntaje() > jugador2.calcularPuntaje())
		{
			System.out.println("\ngana el jugador 2");
		}
		else
		{
			if(turno == 1)
			{
				System.out.println("\ngana el jugador 2");
			}
			else if (turno == 2)
			{
				System.out.println("\ngana el jugador 1");
			}
		}
		
		System.out.println("final del juego");
		
	*/


}
