
package Conexion_Base_de_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author Madeline Yazuri
 */
public class Cls_Conexion {

    private static final String DRIVER      = "com.mysql.cj.jdbc.Driver";
    private static final String USER        = "root";
    private static final String PASSWORD    = "xxxxx";
    private static final String URL         = "jdbc:mysql://127.0.0.1:3306/bibloteca1";
    private Connection CN;
    
    public ResultSet resultado;
    
   public Cls_Conexion (){
        CN = null;
    }

// ESTABLECEMOS CONEXION CON LA BASE DE DATOS
    public Connection getConnection() throws SQLException{
        try{
            Class.forName(DRIVER);
            CN = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
    
        } catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE HIZO LA CONEXIÓN A LA BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
// CERRAR LA CONEXION
    public void close(){
        try{
            CN.close();
        }catch (SQLException ex){
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE CERRO LA CONEXIÓN", JOptionPane.ERROR_MESSAGE);
        }
    }
}

