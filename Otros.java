import java.io.IOException;
import java.util.Scanner;

public class Otros extends NoPerecedero{
String categoria;


    public Otros(){}
    public Otros(int codigo, String nombre, double precio, int cantidad, double peso, String categoria) {
        super(codigo, nombre, precio, cantidad, peso);
        this.categoria=categoria;
        setIva(Constantes.VALOR_IVA_OTROS);
    }


    public Otros(Scanner in) throws IOException {
        super(in);
        this.setIva(Constantes.VALOR_IVA_OTROS);
        System.out.println("Introduzca la categoria");
        categoria= in.nextLine();
    }

    @Override
    public String volcar() {

        return   super.volcar()+" "+this.categoria+ " Otros";
    }

    public void imprimir(){
        super.imprimir();
        System.out.print(Constantes.ANSI_RED + Constantes.TXT_OTROS + Constantes.ANSI_RESET+ this.categoria+"\n");
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
