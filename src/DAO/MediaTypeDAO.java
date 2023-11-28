
package DAO;
import UTIL.*;
import BEAN.*;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MediaTypeDAO {
    
    public void eliminarMediaType(Integer id){
    
        DbBean con;
        con = new DbBean();
        String sql;
        
        sql = " DELETE FROM MediaType WHERE MediaTypeId = " + id + "";
        
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
             e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void actualizaMediaType(MediaType mediaType){
        
        DbBean con;
        con = new DbBean();
        String sql;
      
        sql = " update MediaType set Name = '" + mediaType.getName() + "'";
        sql = sql + " where MediaTypeId = " + mediaType.getMediaTypeId()+ "";
        
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
             e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void insertaMediaType(MediaType mediaType){
        
        DbBean con;
        con = new DbBean();
        String sql;
     
        sql = "insert into MediaType values ( " + mediaType.getMediaTypeId()+ ", ";
        sql = sql + " '" + mediaType.getName()+ "' )" ;
        
        
        
        
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
             e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public Vector<MediaType> listarMediaType(boolean sw, String cad) throws SQLException{
    
        Vector<MediaType> listaMediaType;
        listaMediaType = new Vector<MediaType>();
        DbBean con;
        con = new DbBean();
        ResultSet listaResult;
        
        String sql ="select * from MediaType";
        if(sw == true){
            sql = sql + " where Name like '" + cad +"%'";
        }
            
        try{
            
           listaResult = con.resultadoSQL(sql);
           while(listaResult.next()){
               
               MediaType mediaType = new MediaType();
               mediaType.setMediaTypeId(listaResult.getInt(1));
               mediaType.setName(listaResult.getString(2));
               listaMediaType.addElement(mediaType);
           } 
           
           
           
        }catch(java.sql.SQLException e){
                e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaMediaType;
    
    
    }
    
}
