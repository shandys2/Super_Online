import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Inventario {

    private static Inventario instancia;
    private static ArrayList<Producto> listaProductos;
    private String ficheroInventario ;
    public static int ultimoCodigo=1;

    static FileWriter fw;
    static FileReader fr;
    static BufferedReader bf;


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

    public static void cargarProductos() throws IOException {

        String []temp ;
        try{
            //Abro stream, crea el fichero si no existe
           //  fw=new FileWriter("C:\\BBDD\\productos.txt");
            //Escribimos en el fichero un String y un caracter 97 (a)

           // fw.write("Esto es una prueb");
            //fw.write(97);
            //Cierro el stream
            //fw.close();
            //Abro el stream, el fichero debe existir
             fr=new FileReader("C:\\BBDD\\productos.txt");
             bf= new BufferedReader(fr);
            //Leemos el fichero y lo mostramos por pantalla

            String linea;

            while((linea=bf.readLine())!=null) {
                temp = linea.split(" ");

                String tipoProducto = temp[temp.length - 1]; //miramos el tipo de producto que esta al final de la lectura siempre
                Producto producto = null;

                try {

                    switch (tipoProducto) {

                        case "Lacteo" -> {
                            producto = new Lacteo(Integer.parseInt(temp[0]),
                                    temp[1],
                                    Double.parseDouble(temp[2]),
                                    Integer.parseInt(temp[3]),
                                    Double.parseDouble(temp[4]),
                                    temp[5],
                                    temp[6]);
                        }
                        case "Bebida" -> {
                            producto = new Bebida(Integer.parseInt(temp[0]),
                                    temp[1],
                                    Double.parseDouble(temp[2]),
                                    Integer.parseInt(temp[3]),
                                    Double.parseDouble(temp[4]),
                                    temp[5],
                                    temp[6]); }

                        case "FrutaHortaliza" -> {
                            producto = new FrutaHortaliza(Integer.parseInt(temp[0]),
                                    temp[1],
                                    Double.parseDouble(temp[2]),
                                    Integer.parseInt(temp[3]),
                                    Double.parseDouble(temp[4]),
                                    temp[5],
                                    temp[6]);}
                        case "Herramienta" -> {
                            producto = new Herramienta(Integer.parseInt(temp[0]),
                                    temp[1],
                                    Double.parseDouble(temp[2]),
                                    Integer.parseInt(temp[3]),
                                    Double.parseDouble(temp[4])); }

                        case "Otros" -> {
                            producto = new Otros(Integer.parseInt(temp[0]),
                                    temp[1],
                                    Double.parseDouble(temp[2]),
                                    Integer.parseInt(temp[3]),
                                    Double.parseDouble(temp[4]),
                                    temp[5]); }
                    }
                } catch (Exception e) {
                    System.out.println("Error al insertar el producto");
                } finally {
                    addNuevoProducto(producto);
                }
            }
            System.out.println("[Productos cargados...]");

        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
        finally{
            //Cerramos el stream
            fr.close();
            bf.close();
        }

    }

    public void guardarProductos(){

    }

    public static void addNuevoProducto(Producto p){

        listaProductos.add(p);
        ultimoCodigo++;
    }

    public static void mostrarProductos(){

        for (int i = 1; i < size() ; i++) {
            Producto p= getProducto(i);
            if(p.getCodigo()!=0){
                System.out.println(p.imprimir());
            }
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

        for (int i = 0; i < size() ; i++) {
            Producto p= getProducto(i);
            if(p instanceof Enviable){
              p.imprimirEnvio();
            }
        }

    }

    public void eliminarProducto(int id){


    }

}
