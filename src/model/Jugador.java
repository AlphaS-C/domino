package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    public ArrayList<Ficha> fichas;
    private Scanner entrada;

    public Jugador(ArrayList<Ficha> fichas) {
        this.fichas = fichas ;
    }

    public Jugador() {
        this.fichas = new ArrayList<Ficha>();
    }

    public void ponerFicha(int i)
    {
        this.fichas.remove(i);

    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    public void preguntarMovimiento()
    {
        int indice = -1;
        entrada = new Scanner(System.in);
        System.out.print("que ficha desea mover?: ");

        while(indice<0 || indice >= fichas.size() && fichas.size() > 0)
        {

            indice = entrada.nextInt();
            if(indice<0 || indice >= fichas.size())
            {
                System.out.print("Posicion invalida, intentelo de nuevo: ");
                System.out.print("size: "+fichas.size());
            }
            else
            {
                this.fichas.remove(indice);
            }
        }

    }



    public void imprimirFichas()
    {
        for(int i=0; i<fichas.size(); i++)
        {
            System.out.print(fichas.get(i).imprimirFicha());
        }
    }

}
