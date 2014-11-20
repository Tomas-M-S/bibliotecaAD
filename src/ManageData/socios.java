package ManageData;

/**
 * @author Tomás Martínez Sempere
 * @since 05/11/2014
 */
public class socios {
    protected String nombre;
    protected String apellidos;
    protected String direccion;
    protected int edad;
    protected int telefono;
    protected String dni;

    public socios(String nombre, String apellidos, String direccion, int edad, int telefono, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "[ " + this.getNombre() + ", "
                + this.getApellidos() + ", "
                + this.getDireccion() + ", "
                + this.getEdad() + ", "
                + this.getTelefono() + ", "
                + this.getDni() + " ]";
    }
    
    
    // ===================
    // Getters and setters
    // ===================
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    // </editor-fold>
}
