package aplicacion;

import controller.*;

import model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

	private Mesa mesa = new Mesa();
	private ControladorMesa controller = new ControladorMesa();

	@Override
	public void start(Stage stage) {
		Scene scene;

		MainView mainView = new MainView();

		scene = new Scene(mainView, 1200, 600); // tamaño de la ventana
		stage.setScene(scene);
		stage.show();

		inicializar(mesa, controller, mainView);
		mainView.drawText("Para jugar pulsa la tecla numerica que corresponda", 0, 1);
		mainView.drawText("con la ficha que quieres ubicar en el tablero", 0, 2);

		scene.setOnKeyPressed(e -> {
			if (controller.getBandera() >= 2) {
				mainView.limpiarTablero(0, 0, 56, 6); // limpio la parte superior del tablero
				mainView.drawText("FIN DEL JUEGO", 0, 1);
				mainView.drawText("PRESIONE ENTER PARA JUGAR DE NUEVO", 0, 2);
				mainView.drawText("Puntaje del jugador 1 = " + controller.getJugador().calcularPuntaje(), 0, 3);
				mainView.drawText("Puntaje del jugador 2 = " + controller.getMaquina().calcularPuntaje(), 0, 4);
				mainView.drawText(controller.returnGanador() + "!", 0, 5);

				if (e.getCode() == KeyCode.ENTER) { // para reiniciar el juego
					mesa = new Mesa();
					controller = new ControladorMesa();
					inicializar(mesa, controller, mainView);
					controller.setBandera(0);
				}
			}

			int ind;
			if (e.getCode().isDigitKey()) {

				if (controller.getTurno() == 2 && controller.getBandera() < 2) { // juega el primer turno  
					controller.turno(mesa, 0);
					drawScreen(mesa, controller, mainView);

				}

				else if (e.getCode().isDigitKey() && controller.getBandera() < 2) {
					ind = Integer.parseInt(e.getCode().getName().replaceAll("[^0-9]", "")) - 1; // trukosky pa tomar el
																								// valor del teclado
																								// numerico como int
					controller.turno(mesa, ind);
					drawScreen(mesa, controller, mainView);
					new java.util.Timer().schedule(new java.util.TimerTask() {  // delay para el turno de la maquina
						@Override
						public void run() {
							controller.turno(mesa, 0);
							drawScreen(mesa, controller, mainView);
						}

					}, 1500);
				}

			}
		});

	}

	public void drawScreen(Mesa mesa, ControladorMesa controller, MainView mainView) {
		mainView.drawHand(controller.getJugador());
		mainView.drawMachineHand(controller.getMaquina());
		mainView.drawText("Turno del jugador " + controller.getTurno(), 0, 3);
		if(controller.getBanderaNoPuedeJugar2() == true) {
			mainView.drawText("El jugador 2 no puede jugar", 0, 4);
		}
		if(controller.getBanderaNoPuedeJugar1() == true) {
			mainView.drawText("El jugador 1 no puede jugar", 0, 5);
		}
		mainView.drawTable(mesa);

	}

	public void inicializar(Mesa mesa, ControladorMesa controller, MainView mainView) {
		controller.inicializar(mesa);
		drawScreen(mesa, controller, mainView);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
