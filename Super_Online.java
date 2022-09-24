import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Super_Online {

   static Scanner sc = new Scanner(System.in);
   static List<String> opcionesPrincipales = Arrays.asList("tecla:1  -Cargar productos","tecla:2  -Mostrar inventario","tecla:3  -Actualizar existencias","tecla:4  -Nuevo producto","tecla:5  -Mostrar productos enviables","tecla:6  -Guardar inventario","tecla:0  -Terminar");
   static List<String> tiposDeProductos = Arrays.asList("tecla:1  -Lacteos","tecla:2  -Frutas u hortalizas","tecla:3  -Bebidas","tecla:4  -Herramientas","tecla:5  -Otros","tecla:0  -Cancelar");
   static Inventario inventario = Inventario.getInstance();


    public static void main(String[] args) {
        imprimirMenuPrincipal();
    }


    public static void imprimirMenuPrincipal(){

        String opcion;
        do {
            System.out.println(Constantes.TITULO_MENU_PRINCIPAL);
            mostrarOpcionesPrincipales();

            System.out.println("Escoja una opcion...");
            opcion = sc.nextLine();
            gestionarMenuPrincipal(opcion);
        }while (!opcion.equals("0"));
            System.out.println("Cerrando el programa....");
    }

    public static void imprimirMenuEleccionProducto(){
            System.out.println(Constantes.TITULO_TIPO_PRODUCTO);
            mostrarTiposDeProducto();
    }

    public static void mostrarOpcionesPrincipales(){

        for (String opcion : opcionesPrincipales){
                System.out.println(opcion);
           }
    }
    public static void mostrarTiposDeProducto(){

        for (String tipo : tiposDeProductos){
            System.out.println(tipo);
        }
    }

    public static void cargarProductos(){

     inventario.cargarProductos();
    }

    public static void mostrarInventario(){

        System.out.println("***Lista completa de productos catalogados-------------------------------------");
        imprimirInventarioCompleto();
        System.out.println("Pulse cualquier tecla para volver al menu principal");
        sc.nextLine();
    }
    public static void actualizarExistencias(){

        System.out.println("***Lista completa de productos catalogados-------------------------------------");
        imprimirInventarioCompleto();
        int opcion=0;
        System.out.println("Introduzca el Id del producto a actualizar,");
        opcion = Integer.parseInt(sc.nextLine());
        do {
          try{
              Producto p= inventario.getProducto(opcion);

              if(p.getCodigo()==999999){
                System.out.println(Constantes.ANSI_RED+" No existe producto con ese id" +Constantes.ANSI_RESET);
                return;
               }

              System.out.println(Constantes.ANSI_PURPLE +"Producto elegido "+Constantes.ANSI_RESET +p.getNombre() + Constantes.ANSI_CYAN+" Existencias= "+Constantes.ANSI_RESET +p.getCantidad());
              System.out.println(Constantes.ANSI_YELLOW+"Introduce la nueva cantidad"+ Constantes.ANSI_RESET);
              int nuevaCantidad= Integer.parseInt(sc.nextLine());
              p.setCantidad(nuevaCantidad);
              System.out.println(Constantes.ANSI_PURPLE +"Producto actualizado: " +Constantes.ANSI_RESET +p.getNombre() + Constantes.ANSI_CYAN+ " Nueva cantidad: "+ Constantes.ANSI_RESET+ p.getCantidad());
              System.out.println("Introduzca el Id del producto a actualizar, pulse 0 para salir");
              opcion = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println(Constantes.ANSI_RED+" Error al introducir el dato pedido" +Constantes.ANSI_RESET);
            }
        }while (opcion!=0);
    }

    public static void nuevoProducto(){
        System.out.println("Elige el tipo de producto que quieres anadir....");
        imprimirMenuEleccionProducto();

        String eleccion = sc.nextLine();

        switch (eleccion){
            case "1":{
                Producto producto=new Lacteo(sc);
                inventario.addNuevoProducto(producto);
            } break;
            case "2":{
                Producto producto=new FrutaHortaliza(sc);
                inventario.addNuevoProducto(producto);
            } break;
            case "3":{
                Producto producto=new Bebida(sc);
                inventario.addNuevoProducto(producto);
            } break;
            case "4":{
                Producto producto=new Herramienta(sc);
                inventario.addNuevoProducto(producto);
            } break;
            case "5":{
                Producto producto=new Otros(sc);
                inventario.addNuevoProducto(producto);
            } break;

        }
    }

    public static void mostrarProductosEnviables(){

        System.out.println("mostrando productos envibles");
        inventario.mostrarProductosEnviables();

    }
    public static void guardarInventario(){
        System.out.println("Guardando inventario...");
    }

   public static void gestionarMenuPrincipal(String opcion){

        switch (opcion){
            case "1": cargarProductos();break;
            case "2": mostrarInventario();break;
            case "3": actualizarExistencias();break;
            case "4": nuevoProducto();break;
            case "5": mostrarProductosEnviables();break;
            case "6": guardarInventario();break;
       }
   }

   public static void imprimirInventarioCompleto(){
       for (int i = 0; i < inventario.tamanio() ; i++) {
           Producto p= inventario.getProducto(i);

           if(p.getCodigo()!=0){
               System.out.println(p.imprimir());
           }
       }
   }

}
