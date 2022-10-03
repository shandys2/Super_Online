import java.io.IOException;
import java.util.Scanner;

public class Lacteo extends Perecedero{

    private String lote;

    public Lacteo(int codigo, String nombre, double precio, int cantidad, double peso, String fechacad, String lote) {
        super(codigo, nombre, precio, cantidad, peso, fechacad);
        this.setIva(Constantes.VALOR_IVA_LACTEOS);
        this.lote=lote;
    }

    public Lacteo(Scanner in) throws IOException {
        super(in);
        this.setIva(Constantes.VALOR_IVA_LACTEOS);
        System.out.println("Introduzca el lote del lacteo");
        lote= in.nextLine();
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
        return super.imprimir() + Constantes.ANSI_RED + Constantes.TXT_LACTEOS + Constantes.ANSI_RESET+ this.lote;
    }
    @Override
    public String volcar() {

        return   super.volcar()+" " +this.lote + " Lacteo";
    }
    @Override
    public void imprimirEnvio(){

        super.imprimirEnvio() ;
        System.out.print( Constantes.ANSI_RED+ " PRECIO-TOTAL: " + Constantes.ANSI_RESET+Math.round((this.getPrecio()+this.getIva()+Constantes.TARIFA_ENVIO)*100.0)/100.0  );
        System.out.println("");
    }
}

