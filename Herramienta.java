import java.util.Scanner;

public class Herramienta extends NoPerecedero implements Enviable{

    public Herramienta(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
        setIva(Constantes.VALOR_IVA_HERRAMIENTAS);
    }

    public Herramienta(Scanner in){
        super(in);
        System.out.println("Soy una herramienta construyendose");

    }

    @Override
    public String imprimirEnvio() { return null;}

    @Override
    public boolean envioFragil() { return Constantes.ENVIO_NORMAL;}
    @Override
    public double tarifaEnvio() {return Constantes.TARIFA_ENVIO;}

    public String imprimir(){
        return super.imprimir() + Constantes.ANSI_RED +Constantes.TXT_HERRAMIENTAS + Constantes.ANSI_RESET;
    }
}
