
package Clases;

import Conexion_Base_de_Datos.Cls_Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Cls_Pago {


    private final String SQL_INSERT = " INSERT INTO Pago ( id_Pago, Numero_de_Tarjeta, Fecha_expiracion, Correo_Electronico, Codigo_seguridad, Nombre_Titular, correo_electronico) values(Auto increment,?,?,?,?,?,?) " ;
    private PreparedStatement PS ;
    private final Cls_Conexion CN;
    
    
    public Cls_Pago(){
        PS = null;
        CN = new Cls_Conexion();
        
    }
    
    public int insertarDatos (int id, int num, String ap, String co, String con) throws SQLException{
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);  
            PS.setInt(1,id);
            PS.setInt(2,num);
            PS.setString(3,ap);
            PS.setString(4, co);
            PS.setString(5, con);
            int res = PS.executeUpdate();
           if (res > 0){
               JOptionPane.showMessageDialog (null, "Registro guardado... ");
           }
               
                     
        }catch (SQLException e){
            System.err.println("Error al Guardar Los datos " + e.getMessage());
        } finally{
            PS = null;
            CN.close();
        }
       return 0;
    }
    

