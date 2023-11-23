
package DAO;


import UTIL.*;
import BEAN.*;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {
    
    public void eliminarGenre(Integer id){
    
        DbBean con;
        con = new DbBean();
        String sql;
        
        sql = " DELETE FROM Genre WHERE GenreId = " + id + "";
        
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
    
    public void actualizaGenre(Genre genre){
        
        DbBean con;
        con = new DbBean();
        String sql;
      
        sql = " update Genre set Name = '" + genre.getName() + "'";
        sql = sql + " where GenreId = " + genre.getGenreId()+ "";
        
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
    
    public void insertaGenre(Genre genre){
        
        DbBean con;
        con = new DbBean();
        String sql;
     
        sql = "insert into Genre values ( " + genre.getGenreId()+ ", ";
        sql = sql + " '" + genre.getName()+ "' )" ;
        
        
        
        
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
    
    public Vector<Genre> listarGenre(boolean sw, String cad) throws SQLException{
    
        Vector<Genre> listaGenre;
        listaGenre = new Vector<Genre>();
        DbBean con;
        con = new DbBean();
        ResultSet listaResult;
        
        String sql ="select * from Genre";
        if(sw == true){
            sql = sql + " where Name like '" + cad +"%'";
        }
            
        try{
            
           listaResult = con.resultadoSQL(sql);
           while(listaResult.next()){
               
               Genre genre = new Genre();
               genre.setGenreId(listaResult.getInt(1));
               genre.setName(listaResult.getString(2));
               listaGenre.addElement(genre);
           } 
           
           
           
        }catch(java.sql.SQLException e){
                e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaGenre;
    
    
    }
    
    
}
