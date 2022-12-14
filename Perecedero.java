import java.io.IOException;
import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable{

    private String fechacad;

    public Perecedero(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad) {
        super(codigo, nombre, precio, cantidad, peso);
        this.fechacad=fechacad;
    }
    public Perecedero(Scanner in) throws IOException {
        super(in);
        System.out.println("Introduce la fecha de caducidad (--/--/--)");
        fechacad= in.nextLine();

    }

    public Perecedero(){}

    public String volcar(){
        return super.volcar()+" "+this.fechacad;
  }

    @Override
    public void imprimirEnvio(){
        super.imprimirEnvio() ;
        System.out.print( Constantes.ANSI_YELLOW+ " Tarifa de envio: " + Constantes.TARIFA_ENVIO );

    }
    public void imprimir(){
         super.imprimir();
         System.out.print(Constantes.ANSI_YELLOW+ Constantes.PERECEDERO + Constantes.ANSI_RESET+ fechacad + Constantes.ANSI_YELLOW +")");

    }
    public Boolean envioFragil(){
        return Constantes.ENVIO_FRAGIL;
  }
    public Double tarifaEnvio(){
        return Constantes.TARIFA_ENVIO;
  }

    public String getFechacad() {
        return fechacad;
    }

    public void setFechacad(String fechacad) {
        this.fechacad = fechacad;
    }
}
