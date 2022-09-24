import java.util.Scanner;

public class FrutaHortaliza extends Perecedero {

    private String origen;

    public FrutaHortaliza(int codigo, String nombre, double precio, int cantidad, double peso ,String fechacad, String origen) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.setIva(Constantes.VALOR_IVA_FRUTAS_Y_HORTALIZAS);
        this.origen= origen;

    }
    public FrutaHortaliza(Scanner in){
        super(in);
        System.out.println("Introduzca el origen");
        origen= in.nextLine();
    }
    @Override
    public boolean envioFragil() {
        return Constantes.ENVIO_FRAGIL;
    }
    @Override
    public double tarifaEnvio() {
        return Constantes.TARIFA_ENVIO;
    }

    public String imprimir(){

        return super.imprimir() +Constantes.ANSI_RED + Constantes.TXT_FRUTAS_Y_HORT + Constantes.ANSI_RESET+ this.origen ;
    }

}
