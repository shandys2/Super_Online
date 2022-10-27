
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Super_Online {

   static Scanner in = new Scanner(System.in);
   static Inventario inventario;
   static InventarioDB inventarioDB;

    static {
        try {
            inventario = Inventario.getInstance();
            inventarioDB= InventarioDB.getInstance();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {


        System.out.println(Constantes.BANNER);

        int opcion = 1;

        while (opcion != 0) {
            mostrarMenuInventario();
            System.out.println(Constantes.ANSI_RESET+"Opcion? ");
            opcion = leerOpcion(7); // hay 6 acciones principales sobre el inventario + terminar la aplicaciÃ³n
            switch(opcion) {
                case 0:	System.out.println("Termina la aplicacion");
                    System.exit(0);
                case 1: inventario.migrarInventarioXMLaMYSQL();
                    pause();
                    break; // cargar productos
                case 2: inventarioDB.mostrarProductos();
                    pause();
                    break;
                case 3:     //actualizar la cantidad de un producto en almancÃ©n
                    Producto p;
                    while (opcion!=0) {
                        inventarioDB.mostrarProductos();
                        System.out.println("0 - Finalizar actualizacion del inventario");
                        System.out.println("Elige el numero del producto a actualizar, tecla:x (/= 0):");
                        System.out.println("Opcion? ");
                        opcion = leerOpcion(inventarioDB.size()); //se han mostrado todos los articulos (talla) + opcion de salida
                        if (opcion!=0) {
                            inventarioDB.getProducto(opcion);  //el mismo producto
                            System.out.println("Elige la nueva cantidad:");
                            int cant = in.nextInt();
                            in.nextLine();
                            inventarioDB.actualizarExistrencias(cant,opcion);

                            inventarioDB.getProducto(opcion);
                            pause();
                        }
                    } opcion=1; break;
                case 4: 	//aÑadir un nuevo producto al almancen
                    while (opcion!=0) {

                        mostrarMenuAddNuevoProducto();
                        System.out.println(Constantes.ANSI_PURPLE+"Opcion? " +Constantes.ANSI_RESET);
                        opcion = leerOpcion(6); // 5 clases de productos y salida del menuº
                        if (opcion!=0) {
                            Producto P = nuevoProducto(opcion);
                            inventarioDB.addNuevoProducto(P);
                            System.out.println("Producto aniadido , numero "+(inventarioDB.size()));
                            inventarioDB.getProducto(inventarioDB.size()); //imprime el ultimo producto incluido
                            System.out.println();
                            System.out.println();
                            pause();
                        }
                    } opcion=1; break;
                case 5: inventarioDB.mostrarProductosEnviables();
                    pause();
                    break;
                case 6:
                    while (opcion!=0) {
                    inventarioDB.mostrarProductos();
                    System.out.println("0 - Finalizar actualizacion del inventario");
                    System.out.println("Elige el numero del producto a BORRAR, tecla:x (/= 0):");
                    System.out.println("Opcion? ");
                    opcion = leerOpcion(inventarioDB.size());

                    if (opcion!=0) {
                        inventarioDB.eliminarProducto(opcion);
                        pause();
                    }
                } opcion=1; break;

            }
        }
    }

    public static void mostrarMenuInventario() {// ver productos del super ordenados
        System.out.println(Constantes.MENU_INVENTARIO);
    }
    public static void mostrarMenuAddNuevoProducto() {// ver productos y escoger uno
        System.out.println(Constantes.TITULO_TIPO_PRODUCTO);
    }

    public static Producto nuevoProducto (int n) throws IOException {
        Scanner es = new Scanner (System.in);
        Producto P;
        switch(n) {
            case 1: P = new Lacteo(es);break;
            case 2: P = new FrutaHortaliza(es);break;
            case 3: P = new Bebida(es);break;
            case 4: P = new Herramienta(es);break;
            default: P = new Otros(es);break;
        }
        return P;
    }

    private static void pause() {
        System.out.println("(pulsa 0 para continuar...");
        leerOpcion(1);
    }


    private static int leerOpcion(int max) {
        boolean terminar = false;
        int n = 0;
        while (!terminar) {
            try {
                n = in.nextInt();
                in.nextLine();
                if (n>max || n<0) {
                    throw new Exception();
                }
                terminar = true;
            } catch (Exception e) {
                System.out.println("Opcion incorrecta! elije de nuevo");
                in.nextLine();
            }
        }
        return n;

    }
}
