import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class InventarioDB {

    private static InventarioDB instancia;
    Connection con;
    String sDriver = "com.mysql.cj.jdbc.Driver";
    String sURL = "jdbc:mysql://localhost:3306/inventario";
    PreparedStatement stmt;
    ResultSet resultSet;

    public static InventarioDB getInstance() throws IOException, SQLException, ClassNotFoundException {
        if (instancia == null) {
            instancia = new InventarioDB();
        }
        return instancia;
    }

    private InventarioDB() throws ClassNotFoundException, SQLException {
        Class.forName(sDriver);
        con = DriverManager.getConnection(sURL,"root","");
        System.out.println("Conexion establecida");

        try{
            stmt = con.prepareStatement(" SELECT COUNT(*) AS recordCount FROM information_schema.tables " +
                    "WHERE table_schema = 'inventario'"+
                    "AND table_name = 'productos'"+
                    "LIMIT 1;");
            resultSet = stmt.executeQuery();

        }catch (Exception e){
            System.out.println(stmt);
            System.out.println("NO EXISTE LA TABLA");
        }

        resultSet.next();

        if(resultSet.getString("recordCount").equals("0")){
            Statement statement = con.createStatement();
            System.out.println("no hay tabla en information schema");
            String sql ="CREATE TABLE PRODUCTOS " +
                        "(codigo INT NOT NULL AUTO_INCREMENT, " +
                        " nombre VARCHAR(45) NOT NULL, " +
                        " precio DECIMAL(9,2) NOT NULL, " +
                        " cantidad INT(9) NOT NULL," +
                        " peso DECIMAL(9,2) NOT NULL," +
                        " fechacad VARCHAR(8) DEFAULT 'NULL'," +
                        " lote VARCHAR(25) DEFAULT 'NULL'," +
                        " graduacion VARCHAR(5) DEFAULT 'NULL'," +
                        " categoria VARCHAR(30) DEFAULT 'NULL'," +
                        " tipo VARCHAR(15) NOT NULL," +
                        " origen VARCHAR(45) DEFAULT 'NULL'," +
                        " PRIMARY KEY (codigo))";

            statement.executeUpdate(sql);
            System.out.println("Tabla creada.");

        }else {
            System.out.println("EXISTE LA TABLA");
        }
    }

    public void mostrarProductos() throws SQLException {
        stmt = con.prepareStatement(" SELECT * FROM inventario.productos;");
        resultSet = stmt.executeQuery();
        imprimirProductos(resultSet);
    }

    public void mostrarProductosEnviables() throws SQLException {
        stmt = con.prepareStatement("SELECT * FROM inventario.productos where tipo='Lacteo' or tipo='FrutaHortaliza' or tipo='Bebida' or tipo='Herramienta';");
        resultSet = stmt.executeQuery();
        imprimirProductos(resultSet);
    }

    public void getProducto(int codigo) throws SQLException {
        stmt = con.prepareStatement("SELECT * FROM inventario.productos WHERE codigo=?");
        stmt.setInt(1,codigo);
        resultSet = stmt.executeQuery();
        imprimirProductos(resultSet);
    }

    public int size() throws SQLException {
        stmt = con.prepareStatement("SELECT COUNT(*) FROM inventario.productos;");
        resultSet = stmt.executeQuery();
        resultSet.next();
        int numeroRegistros= resultSet.getInt(1);
        return numeroRegistros;
    }

    public void eliminarProducto(int id) throws SQLException {
        stmt = con.prepareStatement("DELETE FROM inventario.productos WHERE codigo=?");
        stmt.setInt(1,id);
        int res = stmt.executeUpdate();
        comprobarRespuesta(res,"ELIMINAR");
    }

    public void actualizarExistrencias(int nuevaCantidad ,int codigo) throws SQLException {
        stmt = con.prepareStatement("UPDATE inventario.productos SET cantidad=? WHERE codigo=?;");
        stmt.setInt(1,nuevaCantidad);
        stmt.setInt(2,codigo);
        int res = stmt.executeUpdate();
        comprobarRespuesta(res,"ACTUALIZAR");
    }

    public void addNuevoProducto(Producto p) throws SQLException {
        int res;
        if(p instanceof Lacteo) {
            stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,lote,tipo) VALUES (?,?,?,?,?,?,'Lacteo')");
            stmt.setString(1,  p.getNombre());
            stmt.setDouble(2,p.getPrecio());
            stmt.setDouble(3,p.getCantidad());
            stmt.setDouble(4, p.getPeso());
            stmt.setString(5,((Lacteo) p).getFechacad());
            stmt.setString(6, ((Lacteo) p).getLote());
        }
        if(p instanceof Bebida){
            stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,graduacion,tipo) VALUES (?,?,?,?,?,?,'Bebida')");
            stmt.setString(1,  p.getNombre());
            stmt.setDouble(2,p.getPrecio());
            stmt.setDouble(3,p.getCantidad());
            stmt.setDouble(4, p.getPeso());
            stmt.setString(5, ((Bebida) p).getFechacad());
            stmt.setString(6, ((Bebida) p).getGraduacion());
        }
        if(p instanceof FrutaHortaliza){
            stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,fechacad,origen,tipo) VALUES (?,?,?,?,?,?,'FrutaHortaliza')");
            stmt.setString(1,  p.getNombre());
            stmt.setDouble(2,p.getPrecio());
            stmt.setDouble(3,p.getCantidad());
            stmt.setDouble(4, p.getPeso());
            stmt.setString(5,((FrutaHortaliza) p).getFechacad());
            stmt.setString(6, ((FrutaHortaliza) p).getOrigen());
        }
        if(p instanceof Herramienta){
            stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,tipo) VALUES (?,?,?,?,'Herramienta')");
            stmt.setString(1,  p.getNombre());
            stmt.setDouble(2,p.getPrecio());
            stmt.setDouble(3,p.getCantidad());
            stmt.setDouble(4, p.getPeso());
        }
        if(p instanceof Otros){
            stmt = con.prepareStatement(" INSERT INTO inventario.productos (nombre,precio,cantidad,peso,categoria,tipo) VALUES (?,?,?,?,?,'Otros')");
            stmt.setString(1, p.getNombre());
            stmt.setDouble(2, p.getPrecio());
            stmt.setDouble(3, p.getCantidad());
            stmt.setDouble(4, p.getPeso());
            stmt.setString(5, ((Otros) p).getCategoria());
        }
        res= stmt.executeUpdate() ;
        comprobarRespuesta(res,"INSERTAR");
    }

    //comprobamos si la query nos devuelve un 0 o un 1 rows affected
    public void comprobarRespuesta(int res, String msg){
        if(res==1){
            System.out.println("ACCION "+ msg + " EFECTUADA CORRECTAMENTE");
        }else{
            System.out.println("FALLO AL ->"+ msg );
        }
    }

    public void imprimirProductos(ResultSet resultSet) throws SQLException {
        String formatoTabular="|%6s|%-28s|%-8s|%-8s|%-7s|%-9s|%-10s|%-10s|%-15s|%-16s|%-12s|";
        System.out.println(Constantes.ANSI_YELLOW);
        System.out.printf(formatoTabular,"CODIGO","NOMBRE","PRECIO","CANTIDAD","PESO","CADUCIDAD","LOTE","GRADUACION","CATEGORIA","TIPO","ORIGEN");
        System.out.println(Constantes.ANSI_GREEN);

        while(resultSet.next()){
            String codigo = String.valueOf(resultSet.getInt(1));
            String nombre = String.valueOf(resultSet.getString(2));
            String precio = String.valueOf(resultSet.getDouble(3));
            String cantidad = String.valueOf(resultSet.getInt(4));
            String peso = String.valueOf(resultSet.getDouble(5));
            String fechacad = String.valueOf(resultSet.getString(6));
            String lote = String.valueOf(resultSet.getString(7));
            String graduacion = String.valueOf(resultSet.getString(8));
            String categoria = String.valueOf(resultSet.getString(9));
            String tipo =String.valueOf(resultSet.getString(10));
            String origen =String.valueOf(resultSet.getString(11));
            System.out.printf(formatoTabular,codigo,nombre,precio,cantidad,peso,fechacad,lote,graduacion,categoria,tipo,origen);
            System.out.println();
        }
        System.out.println(Constantes.ANSI_RESET);
    }
}
