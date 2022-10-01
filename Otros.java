import java.io.IOException;
import java.util.Scanner;

public class Otros extends NoPerecedero{
String categoria;
    public Otros(int codigo, String nombre, double precio, int cantidad, double peso, String categoria) {
        super(codigo, nombre, precio, cantidad, peso);
        this.categoria=categoria;
        setIva(Constantes.VALOR_IVA_OTROS);
    }

    public Otros(Scanner in) throws IOException {
        super(in);
        System.out.println("Introduzca la categoria");
        categoria= in.nextLine();
    }


    public String imprimir(){

        return super.imprimir() +Constantes.ANSI_RED + Constantes.TXT_FRUTAS_Y_HORT + Constantes.ANSI_RESET+ this.categoria ;
    }
}
