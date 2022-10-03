import java.io.IOException;
import java.util.Scanner;

public class Herramienta extends NoPerecedero implements Enviable{

    public Herramienta(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
        setIva(Constantes.VALOR_IVA_HERRAMIENTAS);
    }

    public Herramienta(Scanner in) throws IOException {
        super(in);
        this.setIva(Constantes.VALOR_IVA_HERRAMIENTAS);

    }
    @Override
    public void imprimirEnvio(){


        super.imprimirEnvio() ;
        System.out.print( Constantes.ANSI_RED+ " PRECIO-TOTAL: " + Constantes.ANSI_RESET+Math.round((this.getPrecio()+this.getIva()+Constantes.TARIFA_ENVIO)*100.0)/100.0 );
        System.out.println("");
    }

    @Override
    public String volcar() {

        return   super.volcar() +" Herramienta";
    }
    @Override
    public boolean envioFragil() { return Constantes.ENVIO_NORMAL;}
    @Override
    public double tarifaEnvio() {return Constantes.TARIFA_ENVIO;}

    public String imprimir(){
        return super.imprimir() + Constantes.ANSI_RED +Constantes.TXT_HERRAMIENTAS + Constantes.ANSI_RESET;
    }
}
