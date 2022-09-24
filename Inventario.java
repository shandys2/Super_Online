import java.util.ArrayList;
import java.util.Vector;

public class Inventario {

    private static Inventario instancia;
    private static ArrayList<Producto> listaProductos;
    private String ficheroInventario ;
    public int ultimoCodigo=1;

    public static Inventario getInstance() {

        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    private Inventario(){
        listaProductos = new ArrayList<>();
    }

    public void cargarProductos(){

        System.out.println("[Cargando productos...]");
        Producto p0 = new Herramienta(  999999,  "0",  0,  0,  0);
        Producto p1 = new Lacteo(  1,  "Queso-Cheedar",  1.50,  14,  20 ,"21/09/2022" ,"210");
        Producto p2 = new Lacteo(  2,  "Leche-Kaiku",  0.50,  34,  29 ,"23/09/2022" ,"111");
        Producto p3 = new Lacteo(  3,  "Yogur-Danone ",  0.40,  10,  17,"20/09/2022" ,"421");
        Producto p4 = new Bebida(  4,  "CocaCola",  2.50,  40,  4 ,"21/09/2022","0");
        Producto p5 = new Bebida(  5,  "Heineken 0.0",  2.00,  40,  4 ,"21/09/2022","0");
        Producto p6 = new Bebida(  6,  "Heineken",  2.50,  40,  4 ,"21/09/2022","4.3");
        Producto p7 = new FrutaHortaliza(  7,  "Esparragos",  1.50,  33,  10,"21/09/2022","Peru");
        Producto p8 = new FrutaHortaliza(  8,  "Alcachofas",  3.50,  12,  6,"21/09/2022","Tudela");
        Producto p9 = new FrutaHortaliza(  9,  "Acelgas",  2.50,  65,  25,"21/09/2022","La Rioja");
        Producto p10 = new Herramienta(  10,  "Martillo",  12.50,  35,  36);
        Producto p11 = new Herramienta(  11,  "Destornillador",  10.50,  45,  15);
        Producto p12 = new Herramienta(  12,  "Taladro",  68.00,  15,  40);
        Producto p13 = new Otros(  13,  "NO ENVIABLE",  68.00,  15,  40 ,"NO ENVIABLE");
        Producto p14 = new Otros(  14,  "NO ENVIABLE2",  68.00,  15,  40 ,"NO ENVIABLE2");

        addNuevoProducto(p0);
        addNuevoProducto(p1);
        addNuevoProducto(p2);
        addNuevoProducto(p3);
        addNuevoProducto(p4);
        addNuevoProducto(p5);
        addNuevoProducto(p6);
        addNuevoProducto(p7);
        addNuevoProducto(p8);
        addNuevoProducto(p9);
        addNuevoProducto(p10);
        addNuevoProducto(p11);
        addNuevoProducto(p12);
        addNuevoProducto(p13);
        addNuevoProducto(p14);

        System.out.println("[Productos cargados...]");
    }

    public void guardarProductos(){

    }

    public void addNuevoProducto(Producto p){

        listaProductos.add(p);
        ultimoCodigo++;
    }

    public void mostrarProductos(){

    }

    public Producto getProducto( int codigo){

        int posicion=0;

        for (int i = 0; i <listaProductos.size() ; i++) {
            if(listaProductos.get(i).getCodigo()==codigo){
               return listaProductos.get(i);
            }
        }
        return listaProductos.get(0);

    }

    public void actualizarCantidad(int codigo, double cant){



    }

    public int tamanio(){
        return listaProductos.size();
    }

    public void mostrarProductosEnviables(){

        for (int i = 0; i < tamanio() ; i++) {
            Producto p= getProducto(i);

            if(p instanceof Enviable){
                System.out.println(p.imprimir());
            }
        }
    }

    public void eliminarProducto(int id){

    }

}
