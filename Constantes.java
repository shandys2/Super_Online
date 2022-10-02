public class Constantes {

    //constantes del menu

    public static final String TITULO_MENU_PRINCIPAL=Constantes.ANSI_GREEN+"\t\t\t\t███████████████████████████"+Constantes.ANSI_YELLOW+"░░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_RED+"███████████████████████████\n" +
                                                     Constantes.ANSI_RESET+"\t\t\t\t                    SISTEMA DE GESTION DE SUPER ONLINE                    \n"+
                                                     Constantes.ANSI_GREEN+"\t\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_YELLOW+"███████████████████████████"+Constantes.ANSI_RED+"░░░░░░░░░░░░░░░░░░░░░░░░░░░\n\n" ;

    public static final String MENU_INVENTARIO =TITULO_MENU_PRINCIPAL+
            Constantes.ANSI_BLUE+"\t\t\t\t            █:1   "+Constantes.ANSI_YELLOW+"- Cargar productos\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            ░:2   "+Constantes.ANSI_YELLOW+"- Mostrar inventario\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            █:3   "+Constantes.ANSI_YELLOW+"- Actualizar existencias\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            ░:4   "+Constantes.ANSI_YELLOW+"- Add nuevo producto\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            █:5   "+Constantes.ANSI_YELLOW+"- Mostrar productos enviables\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            ░:6   "+Constantes.ANSI_YELLOW+"- Guardar inventario\n"+
            Constantes.ANSI_BLUE+"\t\t\t\t            █:0   "+Constantes.ANSI_YELLOW+"- Terminar\n\n"+
            Constantes.ANSI_GREEN+"\t\t\t\t███████████████████████████"+Constantes.ANSI_YELLOW+"███████████████████████████"+Constantes.ANSI_RED+"███████████████████████████\n";



    public static final String TITULO_TIPO_PRODUCTO=Constantes.ANSI_GREEN+"\t\t\t\t███████████████████████████"+Constantes.ANSI_YELLOW+"███████████████████████████"+Constantes.ANSI_RED+"███████████████████████████\n" +
                                                    Constantes.ANSI_RESET+"\t\t\t\t                  Elige el tipo de producto             \n"+
                                                    Constantes.ANSI_GREEN+"\t\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_YELLOW+"░░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_RED+"░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         ░:1 "+Constantes.ANSI_YELLOW+"- Lacteo\n"+
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         █:2 "+Constantes.ANSI_YELLOW+"- Frutas u hortalizas\n"+
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         ░:3 "+Constantes.ANSI_YELLOW+"- Bebidas\n"+
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         █:4 "+Constantes.ANSI_YELLOW+"- Herramientas\n"+
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         ░:5 "+Constantes.ANSI_YELLOW+"- Otros\n"+
                                                    Constantes.ANSI_BLUE+"\t\t\t\t         █:0 "+Constantes.ANSI_YELLOW+"- Cancelar\n"+
                                                    Constantes.ANSI_GREEN+"\t\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_YELLOW+"░░░░░░░░░░░░░░░░░░░░░░░░░░░"+Constantes.ANSI_RED+"░░░░░░░░░░░░░░░░░░░░░░░░░░░\n";



    //Colores para la consola
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static Boolean ENVIO_FRAGIL = Boolean.TRUE;
    public static Boolean ENVIO_NORMAL = Boolean.FALSE;


    //Valores iva
    public static double VALOR_IVA_FRUTAS_Y_HORTALIZAS = 0.16;
    public static double VALOR_IVA_LACTEOS = 0.04;
    public static double VALOR_IVA_BEBIDAS = 0.16;
    public static double VALOR_IVA_HERRAMIENTAS = 0.4;
    public static double VALOR_IVA_OTROS = 0.16;


    public static Double TARIFA_ENVIO = 2.45;


    //Textos app
    public static String PERECEDERO=" (Producto perecedero: ";
    public static String NO_PERECEDERO=" (Producto NO perecedero)";
    public static String TXT_FRUTAS_Y_HORT=" Fruta de origen: ";
    public static String TXT_BEBIDAS=" Bedida de graduacion: ";
    public static String TXT_LACTEOS=" Producto Lacteo: ";
    public static String TXT_HERRAMIENTAS=" Herramienta";
    public static String TXT_OTROS ="Categoria: ";


    public static String BANNER =Constantes.ANSI_GREEN+"\t\t  █████████  █████  █████ ███████████  ██████████ ███████████         ███████    ██████   █████ █████       █████ ██████   █████ ██████████\n" +
            Constantes.ANSI_GREEN+"\t\t ███░░░░░███░░███  ░░███ ░░███░░░░░███░░███░░░░░█░░███░░░░░███      ███░░░░░███ ░░██████ ░░███ ░░███       ░░███ ░░██████ ░░███ ░░███░░░░░█\n" +
            Constantes.ANSI_GREEN+"\t\t░███    ░░░  ░███   ░███  ░███    ░███ ░███  █ ░  ░███    ░███     ███     ░░███ ░███░███ ░███  ░███        ░███  ░███░███ ░███  ░███  █ ░ \n" +
            Constantes.ANSI_YELLOW+"\t\t░░█████████  ░███   ░███  ░██████████  ░██████    ░██████████     ░███      ░███ ░███░░███░███  ░███        ░███  ░███░░███░███  ░██████   \n" +
            Constantes.ANSI_YELLOW+ "\t\t ░░░░░░░░███ ░███   ░███  ░███░░░░░░   ░███░░█    ░███░░░░░███    ░███      ░███ ░███ ░░██████  ░███        ░███  ░███ ░░██████  ░███░░█   \n" +
            Constantes.ANSI_RED+"\t\t ███    ░███ ░███   ░███  ░███         ░███ ░   █ ░███    ░███    ░░███     ███  ░███  ░░█████  ░███      █ ░███  ░███  ░░█████  ░███ ░   █\n" +
            Constantes.ANSI_RED+"\t\t░░█████████  ░░████████   █████        ██████████ █████   █████    ░░░███████░   █████  ░░█████ ███████████ █████ █████  ░░█████ ██████████\n" +
            Constantes.ANSI_RED+"\t\t ░░░░░░░░░    ░░░░░░░░   ░░░░░        ░░░░░░░░░░ ░░░░░   ░░░░░       ░░░░░░░    ░░░░░    ░░░░░ ░░░░░░░░░░░ ░░░░░ ░░░░░    ░░░░░ ░░░░░░░░░░ \n" +
            Constantes.ANSI_RESET+"\t\t                                                                                                                                           \n" +
                                "\t\t                                                                                                                                           \n" +
                                " \t\t                                                                                                                                          ";

}
