import java.util.Scanner;

public abstract class NoPerecedero extends Producto {

    public NoPerecedero(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
    }
    public NoPerecedero(Scanner in)
    {
        super(in);
        System.out.println("soy no perecedero");
    }
    public String imprimir(){

        return super.imprimir()+ Constantes.ANSI_YELLOW + Constantes.NO_PERECEDERO;
    }


}
