
package Conexion_Base_de_Datos;



    //PAQUETES NECESARIOS PARA LA CONEXION
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//CONFIGURACION PARA LA CONEXION
public class Cls_Conexion {
    
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String USER     = "root";      
    private static final String PASSWORD = "xxxxx";
    private static final String URL      = "jdbc:mysql://localhost:3306/bibloteca";
    private Connection CN;
    private Connection getConnetion;
    public Cls_Conexion(){
        CN = null;
    }
    
    
    //ESTABLECEMOS CONEXION CON LA BASE DE DATOS
    public Connection getConnetion(){
        try{
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa", "Conexion",JOptionPane.INFORMATION_MESSAGE );
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR AL CONECTAR A LA BASE DE DATOS",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
    //CERRAMOS LA CONEXION
    public void close(){
        try{
            CN.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR AL CERRAR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    
}
    

