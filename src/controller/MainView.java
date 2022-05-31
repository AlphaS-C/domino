package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import model.*;

public class MainView extends VBox{

	private Canvas canvas;
	private Image image;
	private Affine affine;
	private GraphicsContext g;
	
	public MainView() {
		this.canvas  = new Canvas(800,800);
		this.getChildren().addAll(this.canvas);
		this.affine = new Affine();
		this.affine.appendScale(800f / 28, 800f/ 28);

	}
	
		


 public void drawHand(Jugador jugador1) {
	 
	g = this.canvas.getGraphicsContext2D();
	g.setTransform(this.affine);
	
	
	g.setFill(Color.WHITE);
	g.fillRect(0, 0, 28, 28);
	 
	g.setFill(Color.RED);
	
	for (int i = 0; i < jugador1.getFichas().size() ; i++) {

			// parte de arriba
			g.setFont(new Font("Verdana", 1));
			drawText("" + (i+1), i + 0.2, 25.5);
			
			drawFicha(jugador1.getFichas().get(i).getPtosArriba(), i , 26, 1 , 1, g);
			 
			 // parte abajo
			drawFicha(jugador1.getFichas().get(i).getPtosAbajo(), i , 27, 1 , 1, g);	 
	 	}
	
	
	 g.setFill(Color.GRAY);
	 g.setLineWidth(0.05);
	 // lineas verticales
	 for (int i = 0; i < (jugador1.getFichas().size() + 1); i++) {
		 g.strokeLine(i, 26, i, 28); // los parametros son ( xInicial, yInicial. xFinal, yFinal)
	 }
	 
	 
	 // lineas horizontales
	 for (int j = 26; j < 29; j++) {
		 g.strokeLine(0, j, (jugador1.getFichas().size()), j);  // los parametros son ( xInicial, yInicial. xFinal, yFinal)
	 }
	 
 }
 
 	public void drawText (String text, double x, double y) {
 		g.fillText(text, x, y);
 	}
 
 	public void drawFicha (int fichaNumber, int x, int y, int height, int width, GraphicsContext g) {
		image = new Image( getImage(fichaNumber));
		g.drawImage(image,x,y,height,width);
 	}
 
 
 	public void drawTable(Mesa mesa) {
 		int x = 0;
 		for (int i = 0; i < mesa.getMesa().size(); i++) { 
 			drawFicha(mesa.getMesa().get(i).getPtosArriba(), x , 13, 1 , 1, g);
 			drawFicha(mesa.getMesa().get(i).getPtosAbajo(), x+1 , 13, 1 , 1, g);
 			x+=2;
 		}
 		 
 	}
 	
 
 	private String getImage(int number) {
 		String string = "";
 		if (number == 0) {
 			return "/assets/0.png";
 		}
 		else if (number == 1) {
 			return "/assets/1.png";
 		}
 		else if (number == 2) {
 			return "/assets/2.png"; 		
 			}
 		else if (number == 3) {
 			return "/assets/3.png"; 
 		}
 		else if (number == 4) {
 			return "/assets/4.png"; 
 		}
 		else if (number == 5) {
 			return "/assets/5.png"; 
 		}
 		else if (number == 6) {
 			return "/assets/6.png"; 
 		}
		return string;

 

		}
 	
//	public GraphicsContext getG() {
//		return g; 
//	}
	
}

