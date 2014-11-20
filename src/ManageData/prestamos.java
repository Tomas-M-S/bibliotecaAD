package ManageData;
import java.sql.Date;

/**
 * @author Tomás Martínez Sempere
 * @since 05/11/2014
 */
public class prestamos {
    protected String dni_e;
    protected String isbn_e;
    protected Date fecha_inicio;
    protected Date fecha_final;
    protected Date fecha_devuelto;

    public prestamos(String dni_e, String isbn_e, Date fecha_inicio, Date fecha_final, Date fecha_devuelto) {
        this.dni_e = dni_e;
        this.isbn_e = isbn_e;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.fecha_devuelto = fecha_devuelto;
    }

    @Override
    public String toString() {
        if (fecha_devuelto == null) {
            return "[ " + this.getDni_e() + ", "
                    + this.getIsbn_e() + ", "
                    + this.getFecha_inicio().toString() + ", "
                    + this.getFecha_final().toString() + " ]";
        } else {
            return "[ " + this.getDni_e() + ", "
                    + this.getIsbn_e() + ", "
                    + this.getFecha_inicio().toString() + ", "
                    + this.getFecha_final().toString() + ", "
                    + this.getFecha_devuelto().toString() + " ]";
        }
    }
    

    // ===================
    // Getters and setters
    // ===================
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public String getDni_e() {
        return dni_e;
    }

    public void setDni_e(String dni_e) {
        this.dni_e = dni_e;
    }

    public String getIsbn_e() {
        return isbn_e;
    }

    public void setIsbn_e(String isbn_e) {
        this.isbn_e = isbn_e;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_ginal(Date fecha_final) {
        this.fecha_final = fecha_final;
    }
    
    public Date getFecha_devuelto() {
        return fecha_devuelto;
    }

    public void setFecha_devuelto(Date fecha_devuelto) {
        this.fecha_devuelto = fecha_devuelto;
    }
    // </editor-fold>
}
