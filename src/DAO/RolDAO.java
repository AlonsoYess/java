
package DAO;

import BEAN.Genre;
import BEAN.Rol;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class RolDAO {
    
    public Vector<Rol> listarRol() throws SQLException{
    
        Vector<Rol> listaRol;
        listaRol = new Vector<Rol>();
        DbBean con;
        con = new DbBean();
        ResultSet listaResult;
        
        String sql ="select * from Rol";

            
        try{
            
           listaResult = con.resultadoSQL(sql);
           while(listaResult.next()){
               
               Rol rol = new Rol();
               rol.setRolId(listaResult.getInt(1));
               rol.setNombre(listaResult.getString(2));
               listaRol.addElement(rol);
           } 
           
           
           
        }catch(java.sql.SQLException e){
                e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaRol;
    
       
    }
    
}
