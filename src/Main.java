import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Ficha> baraja = new ArrayList<Ficha>();
		
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 6; j++) {
				Parte lado1 = new Parte(i);
				Parte lado2 = new Parte(j);
				Ficha ficha = new Ficha(lado1, lado2);
				if (revisarRepetidos(baraja, ficha)) {
					baraja.add(ficha);
				
				}
			}
		}
		
		for (int i = 0; i < baraja.size(); i++) {
			System.out.println(baraja.get(i).toString());
		}
		
		
	}

	
	public static boolean revisarRepetidos(ArrayList<Ficha> array, Ficha ficha) {
		boolean flag = true;
		for (int i = 0; i < array.size(); i++) {
			if (ficha.getLado1().getValor() == array.get(i).getLado2().getValor() && ficha.getLado2().getValor() == array.get(i).getLado1().getValor()) {
				flag = false;
			}
		}
		return flag;
	}
	
}
