package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import model.*;

public class MainView extends VBox {

	private Canvas canvas;
	private Image image;
	private Affine affine;
	private GraphicsContext g;
	private int canvasX = 1600;
	private int canvasY = 800;

	private int razonX = canvasX / 28; // dimension divido el total fichas nos da una version analoga del affine
	private int razonY = canvasY / 28;

	public MainView() {
		this.canvas = new Canvas(canvasX, canvasY);
		this.getChildren().addAll(this.canvas);
		this.affine = new Affine(); // affine nos permite escalar y dividir nuestro canvas en una matriz
		this.affine.appendScale(800f / 28, 800f / 28); // el primer valor es x, y el siguiente y. usamos el mismo para
														// los dos para que se una escala cuadrada.

	}

	public void drawHand(Jugador jugador1) {

		g = this.canvas.getGraphicsContext2D();
		g.setTransform(this.affine);

		g.setFill(Color.WHITE);
		g.fillRect(0, 0, razonX, razonY);

		g.setFill(Color.RED); // color rojo para el texto

		for (int i = 0; i < jugador1.getFichas().size(); i++) {

			// parte de arriba
			g.setFont(new Font("Verdana", 1)); // creamos un objeto texto de tamaño '1' (1 respecto al valor del affine)
			drawText("" + (i + 1), calcularMitad(jugador1.getFichas().size()) + i + 0.2, razonY - 2.5);

			drawFicha(jugador1.getFichas().get(i).getPtosArriba(), calcularMitad(jugador1.getFichas().size()) + i,
					razonY - 2, 1, 1, g);

			// parte abajo
			drawFicha(jugador1.getFichas().get(i).getPtosAbajo(), calcularMitad(jugador1.getFichas().size()) + i,
					razonY - 1, 1, 1, g);
		}

		g.setFill(Color.GRAY);
		g.setLineWidth(0.05);
		// lineas verticales
		for (int i = 0; i < (jugador1.getFichas().size() + 1); i++) {
			g.strokeLine(calcularMitad(jugador1.getFichas().size()) + i, razonY - 2,
					calcularMitad(jugador1.getFichas().size()) + i, razonY); // los parametros son ( xInicial, yInicial.
																				// xFinal, yFinal)
		}

		// lineas horizontales
		for (int j = 0; j < 3; j++) {
			g.strokeLine(calcularMitad(jugador1.getFichas().size()), j + razonY - 2,
					calcularMitad(jugador1.getFichas().size()) + (jugador1.getFichas().size()), j + razonY - 2);
		}

	}

	public int calcularMitad(int size) {
		int num = (razonX - size) / 2;
		return num;
	}

	public void drawText(String text, double x, double y) {
		g.setFill(Color.GRAY);
		g.fillText(text, x, y);
	}

	public void drawFicha(int fichaNumber, double x, double y, double height, double width, GraphicsContext g) {
		image = new Image(getImage(fichaNumber));
		g.drawImage(image, x, y, height, width);
	}

	public void limpiarTablero(int x, int y, int height, int width) {
		g.setFill(Color.WHITE);
		g.fillRect(x, y, height, width);
	}

	public void drawTable(Mesa mesa) {
		int x = (calcularMitad(mesa.getMesa().size()));
		for (int i = 0; i < mesa.getMesa().size(); i++) {
			drawFicha(mesa.getMesa().get(i).getPtosArriba(), x, razonY / 2, 1, 1, g);
			drawFicha(mesa.getMesa().get(i).getPtosAbajo(), x + 1, razonY / 2, 1, 1, g);
			x += 2;
		}

	}

	private String getImage(int number) {
		String string = "";
		if (number == 0) {
			return "/assets/0.png";
		} else if (number == 1) {
			return "/assets/1.png";
		} else if (number == 2) {
			return "/assets/2.png";
		} else if (number == 3) {
			return "/assets/3.png";
		} else if (number == 4) {
			return "/assets/4.png";
		} else if (number == 5) {
			return "/assets/5.png";
		} else if (number == 6) {
			return "/assets/6.png";
		}
		return string;

	}

}
