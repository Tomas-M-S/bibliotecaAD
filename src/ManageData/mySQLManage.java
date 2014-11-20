package ManageData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Tomás Martínez Sempere
 * @since 05/11/2014
 */
public class mySQLManage {
    
    private Connection con;
    private String user;
    private String pass;

    /**
     * Constructor para la clase mySQLManage
     * @param user recibe un String con el usuario de la BD
     * @param pass recibe un String con el password de la BD
     */
    public mySQLManage(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    // public void conectar()
    // public void cerrar()
    // <editor-fold defaultstate="collapsed" desc="Métodos de conectar y cerrar">
    /**
     * Función que conecta a la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void conectar()
            throws ClassNotFoundException,
            SQLException,
            InstantiationException,
            IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost/biblioteca?useServerPrepStmts=true",
                this.user,
                this.pass);
    }
    
    /**
     * Función que conecta a la base de datos
     * @throws SQLException 
     */
    public void cerrar()
            throws SQLException {
        con.close();
    }
    // </editor-fold>
    
    
    
    // =====================
    // Punto 2 del ejercicio
    // =====================
    // public int insertar(libros lib)
    // public int insertar(socios soc)
    // public int borrar(libros lib)
    // public int borrar(socios soc)
    // public int modificar(libros lib)
    // public int modificar(socios soc)
    // <editor-fold defaultstate="collapsed" desc="Punto 2">
    /**
     * Función que ejecuta una sentencia sql de inserción
     * @param lib objeto libros a insertar
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema en la inserción
     */
    public int insertar(libros lib)
            throws SQLException {
        String sqlinsert =
                "INSERT INTO libros VALUES "
                + "('" + lib.getTitulo() + "',"
                + "'" + lib.getAutor() + "',"
                + "'" + lib.getIsbn() + "',"
                + "" + lib.getN_paginas() + ","
                + "" + lib.getN_ejemplares() + ","
                + "'" + lib.getEditorial() + "',"
                + "" + lib.getAnno_edicion() + ");";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlinsert);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta una sentencia sql de inserción
     * @param soc objeto socios a insertar
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema en la inserción
     */
    public int insertar(socios soc)
            throws SQLException {
        String sqlinsert =
                "INSERT INTO socios VALUES "
                + "('" + soc.getNombre() + "',"
                + "'" + soc.getApellidos() + "',"
                + "'" + soc.getDireccion() + "',"
                + "" + soc.getEdad() + ","
                + "" + soc.getTelefono() + ","
                + "'" + soc.getDni() + "');";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlinsert);
        stm.close();
        return result;
    }
    
    
    /**
     * Función que ejecuta un delete sobre la base de datos
     * @param lib objeto libros
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int borrar(libros lib)
            throws SQLException {
        String sqldelete =
                "DELETE FROM libros "
                + "WHERE ISBN = '" + lib.getIsbn() + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqldelete);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta un delete sobre la base de datos
     * @param soc objeto socios
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int borrar(socios soc)
            throws SQLException {
        String sqldelete =
                "DELETE FROM socios "
                + "WHERE DNI = '" + soc.getDni() + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqldelete);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta un update sobre un libro en la base de datos
     * @param lib objeto tipo libro
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int modificar(libros lib)
            throws SQLException {
        String sqlupdate =
                "UPDATE libros SET "
                + "titulo = '" + lib.getTitulo() + "', "
                + "autor = '" + lib.getAutor() + "', "
                + "n_paginas = " + lib.getN_paginas() + ", "
                + "n_ejemplares = " + lib.getN_ejemplares() + ", "
                + "editorial = '" + lib.getEditorial() + "', "
                + "anno_edicion = " + lib.getAnno_edicion() + " "
                + "WHERE ISBN = '" + lib.getIsbn() + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlupdate);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta un update sobre un socio en base de datos
     * @param soc objeto tipo socios
     * @return Número de filas afectadas
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int modificar(socios soc)
            throws SQLException {
        String sqlupdate =
                "UPDATE socios SET "
                + "nombre = '" + soc.getNombre() + "', "
                + "apellido = '" + soc.getApellidos() + "', "
                + "direccion = '" + soc.getDireccion() + "', "
                + "edad = " + soc.getEdad() + ", "
                + "telefono = " + soc.getTelefono() + " "
                + "WHERE DNI = '" + soc.getDni() + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlupdate);
        stm.close();
        return result;
    }
    // </editor-fold>
    
    
    
    // =====================
    // Punto 3 del ejercicio
    // =====================
    // public socios consultaSoc(String dnisoc)
    // public ArrayList<socios> consultaSoc(String nombre, String apellidos)
    // public libros consultaLib(String isbnlib)
    // public ArrayList<libros> consultaLib(String titulo, String autor)
    // <editor-fold defaultstate="collapsed" desc="Punto 3">
    /**
     * Busca y devuelve el socio si el dni existe
     * @param dnisoc String con el dni del socio
     * @return devuelve un objeto socios
     * @throws SQLException Si la consulta a la BD falla
     */
    public socios consultaSoc(String dnisoc)
            throws SQLException {
        socios socLibs = null;
        String statement = "SELECT * FROM socios WHERE DNI = '" + dnisoc + "'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(statement);
        while(rs.next()) {
            String n = rs.getString("nombre");
            String a = rs.getString("apellido");
            String d = rs.getString("direccion");
            int e = rs.getInt("edad");
            int t = rs.getInt("telefono");
            String dni = rs.getString("DNI");
            socLibs = new socios(n,a,d,e,t,dni);
        }
        stm.close();
        return socLibs;
    }
    
    /**
     * Busca y devuelve una lista con los resultados de la búsqueda
     * @param nombre String con la cadena a buscar en el campo "nombre"
     * @param apellidos String con la cadena a buscar en el campo "apellido"
     * @return devuelve un ArrayList de objetos socios
     * @throws SQLException Si la consulta a la BD falla
     */
    public ArrayList<socios> consultaSoc(String nombre, String apellidos)
            throws SQLException {
        ArrayList<socios> soc = new ArrayList<>();
        String nomquery = (nombre == null)?"%":"%" + nombre + "%";
        String apellquery = (apellidos == null)?"%":"%" + apellidos + "%";
        String statement = "SELECT * FROM socios WHERE "
                + "nombre LIKE ? "
                + "AND apellido LIKE ?";
        PreparedStatement pstmt = con.prepareStatement(statement);
        pstmt.setString(1, nomquery);
        pstmt.setString(2, apellquery);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            String n = rs.getString("nombre");
            String a = rs.getString("apellido");
            String d = rs.getString("direccion");
            int e = rs.getInt("edad");
            int t = rs.getInt("telefono");
            String dni = rs.getString("DNI");
            soc.add(new socios(n,a,d,e,t,dni));
        }
        pstmt.close();
        return soc;
    }
    
    /**
     * Busca y devuelve el libro si el isbn existe
     * @param isbnlib Recibe un string con un isbn
     * @return devuelve un objeto socios
     * @throws SQLException Si la consulta a la BD falla
     */
    public libros consultaLib(String isbnlib)
            throws SQLException {
        libros libs = null;
        String statement = "SELECT * FROM libros WHERE ISBN = '" + isbnlib + "';";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(statement);
        while(rs.next()) {
            String t = rs.getString("titulo");
            String a = rs.getString("autor");
            String isbn = rs.getString("ISBN");
            int np = rs.getInt("n_paginas");
            int ne = rs.getInt("n_ejemplares");
            String e = rs.getString("editorial");
            int ae = rs.getInt("anno_edicion");
            libs = new libros(t,a,isbn,np,ne,e, ae);
        }
        stm.close();
        return libs;
    }
    
    /**
     * Busca y devuelve una lista con los resultados de la búsqueda
     * @param titulo String con la cadena a buscar en el campo "nombre"
     * @param autor String con la cadena a buscar en el campo "apellido"
     * @return devuelve un ArrayList de objetos libros
     * @throws SQLException Si la consulta a la BD falla
     */
    public ArrayList<libros> consultaLib(String titulo, String autor)
            throws SQLException {
        ArrayList<libros> lib = new ArrayList<>();
        String titquery = (titulo == null)?"%":"%" + titulo + "%";
        String autquery = (autor == null)?"%":"%" + autor + "%";
        String statement = "SELECT * FROM libros WHERE "
                + "titulo LIKE ? "
                + "AND autor LIKE ?";
        PreparedStatement pstmt = con.prepareStatement(statement);
        pstmt.setString(1, titquery);
        pstmt.setString(2, autquery);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            String t = rs.getString("titulo");
            String a = rs.getString("autor");
            String isbn = rs.getString("ISBN");
            int np = rs.getInt("n_paginas");
            int ne = rs.getInt("n_ejemplares");
            String e = rs.getString("editorial");
            int ae = rs.getInt("anno_edicion");
            lib.add(new libros(t,a,isbn,np,ne,e,ae));
        }
        pstmt.close();
        return lib;
    }
    // </editor-fold>
    
    
    
    // =====================
    // Punto 4 del ejercicio
    // =====================
    // public int insertar(prestamos pres)
    // public int borrar(prestamos pres)
    // public int modificar(prestamos pres)
    // public ArrayList<prestamos> consultaAllPres()
    // <editor-fold defaultstate="collapsed" desc="Punto 4">
    /**
     * Función que ejecuta un Insert sobre la base de datos en prestamo
     * @param pres objeto prestamos a insertar
     * @return Número de filas afectadas (debe de ser siempre 1)
     * @throws SQLException Si hay algún problema en la inserción
     */
    public int insertar(prestamos pres)
            throws SQLException {
        SimpleDateFormat fDate;
        fDate = new SimpleDateFormat("yyyy-MM-dd");
        String sqlinsert =
                "INSERT INTO prestamos (dni_e, isbn_e, fecha_inicio, fecha_final) VALUES "
                + "('" + pres.getDni_e() + "',"
                + "'" + pres.getIsbn_e() + "',"
                + "'" + fDate.format(pres.getFecha_inicio()) + "',"
                + "'" + fDate.format(pres.getFecha_final()) + "');";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlinsert);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta un Delete sobre la base de datos en prestamos
     * @param pres objeto prestamos que se quiere borrar
     * @return Número de filas afectadas (debe de ser  siempre 1)
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int borrar(prestamos pres)
            throws SQLException {
        SimpleDateFormat fDate;
        fDate = new SimpleDateFormat("yyyy-MM-dd");
        String sqldelete =
                "DELETE FROM prestamos "
                + "WHERE dni_e = '" + pres.getDni_e() + "' "
                + "AND isbn_e = '" + pres.getIsbn_e() + "' "
                + "AND fecha_inicio = '" + fDate.format(pres.getFecha_inicio()) + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqldelete);
        stm.close();
        return result;
    }
    
    /**
     * Función que ejecuta un Update sobre la base de datos en prestamos
     * Solo se permite modificar la fecha de devolución, el resto de parámetros
     * son clave primaria.
     * @param pres objeto prestamos con los datos a guardar
     * @return Número de filas afectadas (debe de ser siempre 1)
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int modificar(prestamos pres)
            throws SQLException {
        SimpleDateFormat fDate;
        fDate = new SimpleDateFormat("yyyy-MM-dd");
        String sqlupdate =
                "UPDATE prestamos SET "
                + "fecha_devuelto = '" + fDate.format(pres.getFecha_devuelto()) + "', "
                + "fecha_final = '" + fDate.format(pres.getFecha_final()) + "' "
                + "WHERE dni_e = '" + pres.getDni_e() + "' "
                + "AND isbn_e = '" + pres.getIsbn_e() + "' "
                + "AND fecha_inicio = '" + fDate.format(pres.getFecha_inicio()) + "';";
        Statement stm = con.createStatement();
        int result = stm.executeUpdate(sqlupdate);
        stm.close();
        return result;
    }
    
    /**
     * Función que devuelve todos los prestamos
     * @return ArrayList de prestamos
     * @throws SQLException Si hay algún problema con la inserción
     */
    public ArrayList<prestamos> consultaAllPres()
            throws SQLException {
        String sqlquery = "SELECT * FROM prestamos;";
        ArrayList<prestamos> lista = new ArrayList<>();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlquery);
        while(rs.next()) {
            String dni = rs.getString("dni_e");
            String isbn = rs.getString("isbn_e");
            Date di = rs.getDate("fecha_inicio");
            Date df = rs.getDate("fecha_final");
            Date dd = rs.getDate("fecha_devuelto");
            lista.add(new prestamos(dni,isbn,di,df,dd));
        }
        stm.close();
        return lista;
    }
    // </editor-fold>
    
    
    
    // =====================
    // Punto 5 del ejercicio
    // =====================
    // public ArrayList<libros> consultaLibrosPrestados()
    // public int consultaNumeroLibros(socios soc)
    // public ArrayList<libros> consultaLibrosExcedidos()
    // public ArrayList<socios> consultaSociosExcedidos()
    // <editor-fold defaultstate="collapsed" desc="Punto 5">
    /**
     * El método devuelve una lista con los libros actualmente en préstamo
     * @return ArrayList de libros
     * @throws SQLException Si hay algún problema con la inserción
     */
    public ArrayList<libros> consultaLibrosPrestados()
            throws SQLException {
        String sqlquery =
                "SELECT libros.* FROM libros, prestamos "
                + "WHERE prestamos.isbn_e = libros.ISBN "
                + "AND prestamos.fecha_devuelto IS NULL;";
        ArrayList<libros> lista = new ArrayList<>();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlquery);
        while(rs.next()) {
            String t = rs.getString("titulo");
            String a = rs.getString("autor");
            String isbn = rs.getString("ISBN");
            int np = rs.getInt("n_paginas");
            int ne = rs.getInt("n_ejemplares");
            String e = rs.getString("editorial");
            int ae = rs.getInt("anno_edicion");
            lista.add(new libros(t,a,isbn,np,ne,e, ae));
        }
        stm.close();
        return lista;
    }
    
    /**
     * Función que devuelve el número de libros prestados a un socio
     * determinado desde el principio
     * @param soc Objeto socio
     * @return un int con el número de tuplas de la consulta
     * @throws SQLException Si hay algún problema con la inserción
     */
    public int consultaNumeroLibros(socios soc)
            throws SQLException {
        String sqlquery =
                "SELECT COUNT(*) AS NUMS FROM prestamos "
                + "WHERE dni_e = '" + soc.getDni() + "';";
        int number = 0;
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlquery);
        rs.next();
        number = rs.getInt("NUMS");
        stm.close();
        return number;
    }
    
     /**
     * Función que devuelve una lista de libros excedidos de fecha
     * @return devuelve un ArrayList de libros
     * @throws SQLException Si hay algún problema con la inserción
     */
    public ArrayList<libros> consultaLibrosExcedidos()
            throws SQLException {
        String sqlquery =
                "SELECT libros.* FROM libros, prestamos "
                + "WHERE prestamos.isbn_e = libros.ISBN "
                + "AND (DATE(prestamos.fecha_final) < DATE(prestamos.fecha_devuelto) "
                + "OR ((DATE(prestamos.fecha_final) < CURDATE())"
                + "AND (prestamos.fecha_devuelto IS NULL)));";
        ArrayList<libros> lista = new ArrayList<>();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlquery);
        while(rs.next()) {
            String t = rs.getString("titulo");
            String a = rs.getString("autor");
            String isbn = rs.getString("ISBN");
            int np = rs.getInt("n_paginas");
            int ne = rs.getInt("n_ejemplares");
            String e = rs.getString("editorial");
            int ae = rs.getInt("anno_edicion");
            lista.add(new libros(t,a,isbn,np,ne,e, ae));
        }
        stm.close();
        return lista;
    }
    
    /**
     * Función que devuelve una lista de socios con libros excedidos
     * @return ArrayList de socios
     * @throws SQLException Si hay algún problema con la inserción
     */
    public ArrayList<socios> consultaSociosExcedidos()
            throws SQLException {
        String sqlquery =
                "SELECT DISTINCT socios.* FROM socios, prestamos "
                + "WHERE prestamos.dni_e = socios.DNI "
                + "AND DATE(prestamos.fecha_final) < CURDATE();";
        ArrayList<socios> lista = new ArrayList<>();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sqlquery);
        while(rs.next()) {
            String n = rs.getString("nombre");
            String a = rs.getString("apellido");
            String d = rs.getString("direccion");
            int e = rs.getInt("edad");
            int t = rs.getInt("telefono");
            String dni = rs.getString("DNI");
            lista.add(new socios(n,a,d,e,t,dni));
        }
        stm.close();
        return lista;
    }
    // </editor-fold>

}
