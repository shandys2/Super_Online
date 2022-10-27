import java.io.IOException;
import java.util.Scanner;

public class Bebida extends Perecedero{

    private String graduacion;

    public Bebida(){ }

    public Bebida(int codigo, String nombre, double precio, int cantidad, double peso,String fechacad, String graduacion) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.setIva(Constantes.VALOR_IVA_BEBIDAS);
        this.graduacion= graduacion;
    }
    public Bebida(Scanner in) throws IOException {
        super(in);
        this.setIva(Constantes.VALOR_IVA_BEBIDAS);
        System.out.println("Introduzca la graduacion");
        graduacion= in.nextLine();
    }
    @Override
    public Boolean envioFragil() {
        return Constantes.ENVIO_NORMAL;
    }
    @Override
    public Double tarifaEnvio() {
        return Constantes.TARIFA_ENVIO;
    }

    public void imprimir(){
         super.imprimir();
         System.out.print(Constantes.ANSI_RED + Constantes.TXT_BEBIDAS + Constantes.ANSI_RESET+ this.graduacion+"\n");
    }
    @Override
    public String volcar() {

        return   super.volcar()+" "+ this.graduacion+ " Bebida";
    }
    @Override
    public void imprimirEnvio(){

        super.imprimirEnvio() ;
        System.out.print( Constantes.ANSI_RED+ " PRECIO-TOTAL: " + Constantes.ANSI_RESET+Math.round((this.getPrecio()+this.getIva()+Constantes.TARIFA_ENVIO)*100.0)/100.0 );
        System.out.println("");
    }

    public String getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(String graduacion) {
        this.graduacion = graduacion;
    }
}
