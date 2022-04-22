import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Ficha> baraja = new ArrayList<Ficha>();
		
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 6; j++) {
				Parte lado1 = new Parte(i);
				Parte lado2 = new Parte(j);
				baraja.add(new Ficha(lado1, lado2));
				
				
			}
		}
		
		for (int i = 0; i < baraja.size(); i++) {
			System.out.println(baraja.get(i).toString());
		}
		
		
	}

}
