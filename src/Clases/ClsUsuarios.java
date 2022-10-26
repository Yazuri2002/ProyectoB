
package Clases;

import Conexion_Base_de_Datos.Cls_Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Date;

public class ClsUsuarios {
    private final String SQL_INSERT = " INSERT INTO Usuarios ( id_Usuarios, Nombre, Apellido, Fecha_de_Nacimiento, Genero, Correo_Electronico, Contraseña) values(auto_increment ,?,?,?,?,?,?) " ;
    private PreparedStatement PS ;
    private final Cls_Conexion CN;
    
    
    public ClsUsuarios(){
        PS = null;
        CN = new Cls_Conexion();
        
    }
    
    public int insertarDatos (int id, String nom, String ap, Date fe, String ge, String co, String con) throws SQLException{
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);  
            PS.setInt(1,id);
            PS.setString(2,nom);
            PS.setString(3,ap);
            PS.setDate(4, (java.sql.Date) fe);
            PS.setString(5, ge);
            PS.setString(6, co);
            PS.setString(7, con);
            int res = PS.executeUpdate();
           if (res > 0){
               JOptionPane.showMessageDialog (null, "Registro guardado... ");
           }
               
                     
        }catch (HeadlessException e){
            System.err.println("Eroor al Guardar Los datos " + e.getMessage());
        } finally{
            PS = null;
            CN.close();
        }
       return 0;
    }

    public void insertarDatos(int WIDTH, String nom, String ap, String fe, String fe0, String co, String con) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
