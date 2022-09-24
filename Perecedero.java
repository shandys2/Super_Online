import java.util.Scanner;

public abstract class Perecedero extends Producto implements Enviable{

    private String fechacad;

    public Perecedero(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad) {
        super(codigo, nombre, precio, cantidad, peso);
        this.fechacad=fechacad;
    }
    public Perecedero(Scanner in){
        super(in);
        System.out.println("Introduce la fecha de caducidad (--/--/--)");
        fechacad= in.nextLine();


    }

    public String volcar(){
        return "vocando desde perecedero";
  }

    @Override
    public String imprimirEnvio(){return "IMPRIMIENDO ENVIO";

    }
    public String imprimir(){
        return super.imprimir()+ Constantes.ANSI_YELLOW+ Constantes.PERECEDERO + Constantes.ANSI_RESET+ fechacad + Constantes.ANSI_YELLOW +")";

    }
    public boolean envioFragil(){
        return Constantes.ENVIO_FRAGIL;
  }
    public double tarifaEnvio(){
        return Constantes.TARIFA_ENVIO;
  }


}