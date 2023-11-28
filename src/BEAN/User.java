package BEAN;

public class User {
    
    private int UserId;
    private String Username;
    private String Password;
    private Employee employee;  // Cambio en el tipo de la propiedad
    private Rol rol;
    
    public User(){        
    }
    
    public User(int UserId, String Username, String Password, Employee employee , Rol rol) {
        this.UserId = UserId;
        this.Username = Username;
        this.Password = Password;
        this.employee = employee;  
        this.rol = rol;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
