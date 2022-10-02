import java.io.IOException;
import java.util.Scanner;

public abstract class Producto {

    private Double iva ,peso,precio;
    private Integer codigo,cantidad;
    private String nombre;

    public Producto(int codigo, String nombre, double precio, int cantidad, double peso){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
    };
    public Producto(Scanner in) throws IOException {

        this.codigo=(Inventario.getInstance().ultimoCodigo);

        System.out.println("Introduce el nombre del producto (String)");
        nombre = in.nextLine();
        System.out.println("Introduce el precio del producto  por unidad en €");
        precio=in.nextDouble();
        System.out.println("Introduce la cantidad (numero de unidades)");
        cantidad = in.nextInt();
        System.out.println("Introduce el peso del producto por unidad (en kg)");
        peso=in.nextDouble();
        //solucion rara de buffer
        in.nextLine();

    }

    public double getPeso(){
        return this.peso;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public double getPrecio(){ return this.precio;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public double getIva(){
        return this.iva;
    }

    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public void setPrecio(double pr){
        this.precio=pr;
    }

    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setIva(double iva){
        this.iva=iva;
    }

    public double calcularPrecioIva(){
        return this.getPrecio() + this.getIva();
    }

    public String imprimir(){
        return Constantes.ANSI_GREEN+
                "\t\t\t\t Id:" +Constantes.ANSI_RESET +this.getCodigo() +Constantes.ANSI_GREEN+
               " Nombre:"+Constantes.ANSI_RESET+ this.getNombre() +Constantes.ANSI_GREEN+
               " Cantidad:"+Constantes.ANSI_RESET + this.getCantidad()+Constantes.ANSI_GREEN +
               " Precio:"+Constantes.ANSI_RESET + this.getPrecio();
    }


    public String volcar(){
        return "Volcando....";
    }

    public void imprimirEnvio(){

        System.out.print( "\t\t\t\t Id:" +Constantes.ANSI_RESET +this.getCodigo() +Constantes.ANSI_GREEN+
                        " Nombre:"+Constantes.ANSI_RESET+ this.getNombre() +Constantes.ANSI_GREEN+
                        " Peso:"+Constantes.ANSI_RESET+ this.getPeso() +Constantes.ANSI_GREEN +
                        " IVA:"+Constantes.ANSI_RESET+ this.getPeso() +Constantes.ANSI_GREEN);
    }

}
