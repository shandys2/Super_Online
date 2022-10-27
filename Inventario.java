import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Inventario {

    private static Inventario instancia;
    private static ArrayList<Producto> listaProductos ;
    private String ficheroInventario ;
    public static int ultimoCodigo=1;
    public static final long serialVersionUID=42L;
    static FileWriter fw;
    static FileReader fr;
    static BufferedReader bf;
    static BufferedWriter bw;


    public static Inventario getInstance() throws IOException {

        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    private Inventario() throws IOException {
        listaProductos = new ArrayList<>();
    }

    public static void volcarProductos() {
        System.out.println("Volcando productos...");
    }

    public static void migrarInventarioXMLaMYSQL() throws IOException, ClassNotFoundException, SQLException {

        //Metemos la conexion temporalmente para hacer la migracion
        Connection con;
        String sDriver = "com.mysql.cj.jdbc.Driver";
        String sURL = "jdbc:mysql://localhost:3306/inventario";
        PreparedStatement stmt;
        Class.forName(sDriver);
        con = DriverManager.getConnection(sURL,"root","");
        System.out.println("Conexion establecida");


        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("productosXML.txt")));
        listaProductos= (ArrayList<Producto>) decoder.readObject();
        for (Producto p:listaProductos) {
            p.imprimir();

            if(p instanceof Lacteo) {
                stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,lote,tipo) VALUES (?,?,?,?,?,?,'Lacteo')");
                stmt.setString(1,  p.getNombre());
                stmt.setDouble(2,p.getPrecio());
                stmt.setDouble(3,p.getCantidad());
                stmt.setDouble(4, p.getPeso());
                stmt.setString(5,((Lacteo) p).getFechacad());
                stmt.setString(6, ((Lacteo) p).getLote());
                boolean i= stmt.execute() ;
            }

            if(p instanceof Bebida){
                stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,graduacion,tipo) VALUES (?,?,?,?,?,?,'Bebida')");
                stmt.setString(1,  p.getNombre());
                stmt.setDouble(2,p.getPrecio());
                stmt.setDouble(3,p.getCantidad());
                stmt.setDouble(4, p.getPeso());
                stmt.setString(5, ((Bebida) p).getFechacad());
                stmt.setString(6, ((Bebida) p).getGraduacion());
                boolean i= stmt.execute() ;
            }
            if(p instanceof FrutaHortaliza){
                stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,origen,tipo) VALUES (?,?,?,?,?,?,'FrutaHortaliza')");
                stmt.setString(1,  p.getNombre());
                stmt.setDouble(2,p.getPrecio());
                stmt.setDouble(3,p.getCantidad());
                stmt.setDouble(4, p.getPeso());
                stmt.setString(5,((FrutaHortaliza) p).getFechacad());
                stmt.setString(6, ((FrutaHortaliza) p).getOrigen());
                boolean i= stmt.execute() ;

            }
            if(p instanceof Herramienta){
                stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,tipo) VALUES (?,?,?,?,'Herramienta')");
                stmt.setString(1,  p.getNombre());
                stmt.setDouble(2,p.getPrecio());
                stmt.setDouble(3,p.getCantidad());
                stmt.setDouble(4, p.getPeso());

                boolean i= stmt.execute() ;
            }
            if(p instanceof Otros){
                //System.out.println(p.getNombre()+ " es Otros");

                stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,categoria,tipo) VALUES (?,?,?,?,?,'Otros')");
                stmt.setString(1, p.getNombre());
                stmt.setDouble(2, p.getPrecio());
                stmt.setDouble(3, p.getCantidad());
                stmt.setDouble(4, p.getPeso());
                stmt.setString(5, ((Otros) p).getCategoria());
                boolean i= stmt.execute() ;
            }
        }
        decoder.close();
    }

    public void guardarProductos() throws FileNotFoundException {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("productosXML.txt")));
        encoder.writeObject(listaProductos);
        encoder.flush();
        encoder.close();
    }


    public static void addNuevoProducto(Producto p){
        listaProductos.add(p);
        ultimoCodigo++;
    }

    public static void mostrarProductos(){
        for (int i = 1; i < size() ; i++) {
            Producto p= getProducto(i);
            p.imprimir();
        }
    }

    public static Producto getProducto( int codigo){

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

    public static int size(){
        return listaProductos.size()+1;
    }

    public static void mostrarProductosEnviables(){

        for (int i = 1; i < size() ; i++) {
            Producto p= getProducto(i);
            if(p instanceof Enviable){
              p.imprimirEnvio();
            }
        }
    }

    public void eliminarProducto(int id){


    }

}
