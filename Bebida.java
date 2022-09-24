import java.util.Scanner;

public class Bebida extends Perecedero{

    private String graduacion;

    public Bebida(int codigo, String nombre, double precio, int cantidad, double peso,String fechacad, String graduacion) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.setIva(Constantes.VALOR_IVA_BEBIDAS);
        this.graduacion= graduacion;
    }
    public Bebida(Scanner in){
        super(in);
        System.out.println("Introduzca la graduacion");
        graduacion= in.nextLine();
    }
    @Override
    public boolean envioFragil() {
        return Constantes.ENVIO_NORMAL;
    }
    @Override
    public double tarifaEnvio() {
        return Constantes.TARIFA_ENVIO;
    }

    public String imprimir(){
        return super.imprimir() +Constantes.ANSI_RED + Constantes.TXT_BEBIDAS + Constantes.ANSI_RESET+ this.graduacion;
    }

}
