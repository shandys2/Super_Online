import java.io.IOException;
import java.util.Scanner;

public class FrutaHortaliza extends Perecedero {

    private String origen;

    public FrutaHortaliza(){ }

    public FrutaHortaliza(int codigo, String nombre, double precio, int cantidad, double peso ,String fechacad, String origen) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.setIva(Constantes.VALOR_IVA_FRUTAS_Y_HORTALIZAS);
        this.origen= origen;

    }
    public FrutaHortaliza(Scanner in) throws IOException {
        super(in);
        this.setIva(Constantes.VALOR_IVA_FRUTAS_Y_HORTALIZAS);
        System.out.println("Introduzca el origen");
        origen= in.nextLine();
    }
    @Override
    public Boolean envioFragil() {
        return Constantes.ENVIO_FRAGIL;
    }
    @Override
    public Double tarifaEnvio() {
        return Constantes.TARIFA_ENVIO;
    }
    @Override
    public String volcar() {

        return   super.volcar()+" "+ this.origen+ " FrutaHortaliza";
    }

    public void imprimir(){
        super.imprimir() ;
        System.out.print(Constantes.ANSI_RED + Constantes.TXT_FRUTAS_Y_HORT + Constantes.ANSI_RESET+ this.origen+"\n" );
    }
    @Override
    public void imprimirEnvio(){

        super.imprimirEnvio() ;
        System.out.print( Constantes.ANSI_RED+ " PRECIO-TOTAL: " + Constantes.ANSI_RESET+Math.round((this.getPrecio()+this.getIva()+Constantes.TARIFA_ENVIO)*100.0)/100.0  );
        System.out.println("");

    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
