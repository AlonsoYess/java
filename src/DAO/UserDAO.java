
package DAO;

import UTIL.*;
import BEAN.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    
    public void eliminarUser(Integer id){
    
        DbBean con;
        con = new DbBean();
        String sql;
        
        sql = " DELETE FROM User WHERE UserId = " + id + "";
        
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
    
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            
            // Convertir los bytes en una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void actualizaUser(User user){
        
        DbBean con;
        con = new DbBean();
        String sql;
      
        sql = "UPDATE [User] SET ";
        sql += "Username = '" + user.getUsername() + "'";
        sql += ", Password = '" + this.encryptPassword(user.getPassword())  + "'";
        sql += ", EmployeeId = " + user.getEmployee().getEmployeeId();
        sql += ", RolId = " + user.getRol().getRolId();
        sql += " WHERE UserId = " + user.getUserId();
        
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
    
    public void insertaUser(User user){
        
        DbBean con;
        con = new DbBean();
        
        
        String sql = "INSERT INTO [User] (UserId, Username, Password, EmployeeId, RolId) VALUES (";
    
        
        sql += user.getUserId() + ", ";
        sql += "'" + user.getUsername() + "', ";
        sql += "'" + encryptPassword(user.getPassword()) + "', "; 
        sql += user.getEmployee().getEmployeeId() + " , ";
        sql += user.getRol().getRolId()+ ")"; 
        
        
        
        
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
    
    
    public Vector<Employee> listarEmpleadoCombo(){
        
        Vector<Employee> listaEmpleado;
        listaEmpleado = new Vector<Employee>();
        DbBean con;
        con = new DbBean();
        ResultSet listaResult;
        
        String sql ="select * from Employee";
        
        
        try{
            
           listaResult = con.resultadoSQL(sql);
           while(listaResult.next()){
               
               Employee emp = new Employee();
               emp.setEmployeeId(listaResult.getInt(1));
               emp.setFirstName(listaResult.getString(3));
               listaEmpleado.addElement(emp);
           } 
           
           
           
        }catch(java.sql.SQLException e){
                e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaEmpleado;
        
    }
    
    public Vector<User> listarUser(boolean sw, String cad) throws SQLException{
    
        Vector<User> listaUser;
        listaUser = new Vector<User>();
        DbBean con;
        con = new DbBean();
        ResultSet listaResult;
        
        String sql = "SELECT u.*, e.* , r.* FROM [User] u ";
        sql += " LEFT JOIN Employee e ON u.EmployeeId = e.EmployeeId "; 
        sql += " LEFT JOIN Rol r ON r.RolId = u.RolId";

        if (sw) {
            sql += " WHERE u.Username LIKE '" + cad + "%'";
        }

            
        try{
           
           listaResult = con.resultadoSQL(sql);
           while(listaResult.next()){
               
            User user = new User();
            user.setUserId(listaResult.getInt("UserId"));
            user.setUsername(listaResult.getString("Username"));
            
            // Obtener el nombre del empleado directamente de la consulta
            Employee employee = new Employee();
            employee.setEmployeeId(listaResult.getInt("EmployeeId"));
            employee.setFirstName(listaResult.getString("FirstName")); 
           
            Rol rol = new Rol();
            rol.setRolId(listaResult.getInt("RolId"));
            rol.setNombre(listaResult.getString("Nombre"));
           
            user.setRol(rol);
            user.setEmployee(employee);
            
            listaUser.addElement(user);
           } 
           
           
           
        }catch(java.sql.SQLException e){
                
                e.printStackTrace();
        }
        
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaUser;
    
    
    }
    
    
}
