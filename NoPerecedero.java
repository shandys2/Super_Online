import java.io.IOException;
import java.util.Scanner;

public abstract class NoPerecedero extends Producto {

    public NoPerecedero(){}

    public NoPerecedero(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
    }
    public NoPerecedero(Scanner in) throws IOException {
        super(in);
        System.out.println("soy no perecedero");
    }
    public void imprimir(){
        super.imprimir();
        System.out.print(Constantes.ANSI_YELLOW + Constantes.NO_PERECEDERO);
    }



}
