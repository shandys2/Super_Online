import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Producto implements Serializable {

    private Double iva ,peso,precio;
    private Integer codigo,cantidad;
    private String nombre;

    public Producto(){}

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

    public Double getPeso(){
        return this.peso;
    }

    public Integer getCodigo(){
        return this.codigo;
    }

    public Double getPrecio(){ return this.precio;
    }
    public Integer getCantidad(){
        return this.cantidad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Double getIva(){
        return this.iva;
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }


    public void setIva(Double iva) {
        this.iva = iva;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    public double calcularPrecioIva(){
        return this.getPrecio() + this.getIva();
    }

    public void imprimir(){
        System.out.print(Constantes.ANSI_GREEN+
                "\t\t\t\t Id:" +Constantes.ANSI_RESET +this.getCodigo() +Constantes.ANSI_GREEN+
                " Nombre:"+Constantes.ANSI_RESET+ this.getNombre() +Constantes.ANSI_GREEN+
                " Cantidad:"+Constantes.ANSI_RESET + this.getCantidad()+Constantes.ANSI_GREEN +
                " Precio:"+Constantes.ANSI_RESET + this.getPrecio() );
    }

    public String volcar(){
        return this.getCodigo() +" "+this.getNombre()+" " + this.getPrecio()+" " +
                this.getCantidad()+ " " + this.getPeso();
    }

    public void imprimirEnvio(){

        System.out.print( "\t\t\t\t Id:" +Constantes.ANSI_RESET +this.getCodigo() +Constantes.ANSI_GREEN+
                        " Nombre:"+Constantes.ANSI_RESET+ this.getNombre() +Constantes.ANSI_GREEN+
                        " Peso:"+Constantes.ANSI_RESET+ this.getPeso() +Constantes.ANSI_GREEN +
                        " IVA:"+Constantes.ANSI_RESET+ this.getIva() +Constantes.ANSI_GREEN);
    }

}
