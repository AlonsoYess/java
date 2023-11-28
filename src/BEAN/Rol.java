
package BEAN;


public class Rol {
    
    private int RolId;
    private String Nombre;

    public Rol(int RolId, String Nombre) {
        this.RolId = RolId;
        this.Nombre = Nombre;
    }

    public Rol() {
    }

    public int getRolId() {
        return RolId;
    }

    public void setRolId(int RolId) {
        this.RolId = RolId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    @Override
    public String toString() {
        return getNombre();
    }

    
}
