package managelibrary;
import ManageData.mySQLManage;
import java.sql.*;
import ManageData.*;
import java.util.ArrayList;

/**
 * @author Tomás Martínez Sempere
 */
public class ManageLibrary {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        
        
        try {
            mySQLManage myBIB;
            myBIB = new mySQLManage("root","");
            myBIB.conectar();
        
            
            // <editor-fold defaultstate="collapsed" desc="Pruebas Punto 2">

                try {
                    // Objects for testing:
                    libros lib = new libros("El Giro", "Stephen Greenblatt", "978-84-9892-412-1", 320, 1, "Critica", 2012);
                    socios soc = new socios("Hervasio", "Piedecausa", "Calle Mayor Nº12", 29, 852852844, "48570441G");
                    libros libMod = new libros("El Giro", "Stephen Greenblatt", "978-84-9892-412-1", 320, 30, "Critica", 2012);
                    socios socMod = new socios("Hervasio", "Piedecausa", "Calle De la Desesperacion", 29, 852852844, "48570441G");

                    // Inserta:
                    //System.out.println("Insertada/s " + myBIB.insertar(lib) + " fila/s");
                    //System.out.println("Insertada/s " + myBIB.insertar(soc) + " fila/s");

                    // Modifica:
                    //System.out.println("Modificada/s " + myBIB.modificar(libMod) + " fila/s");
                    //System.out.println("Modificada/s " + myBIB.modificar(socMod) + " fila/s");

                    // Borra:
                    //System.out.println("Borrada/s " + myBIB.borrar(libMod) + " fila/s");
                    //System.out.println("Borrada/s " + myBIB.borrar(socMod) + " fila/s");

                } catch (Exception e) {
                    System.out.println(e);
                }

            // </editor-fold>


            // <editor-fold defaultstate="collapsed" desc="Pruebas Punto 3">

                //System.out.println(myBIB.consultaSoc("48570440Y").toString());

                //ArrayList<socios> soc = myBIB.consultaSoc(null, "mar");
                //for (socios s : soc) {
                //    System.out.println(s.toString());
                //}

                //System.out.println(myBIB.consultaLib("8426418805").toString());

                //ArrayList<libros> lib = myBIB.consultaLib("ph", null);
                //for (libros l : lib) {
                //    System.out.println(l.toString());
                //}

            // </editor-fold>


            // <editor-fold defaultstate="collapsed" desc="Pruebas Punto 4">

                // El formato de las fechas con Date (bastante raro) se pueden ser aquí:
                // http://www.aprenderaprogramar.es/index.php?option=com_content&view=article&id=618:clase-date-del-api-java-metodos-before-after-tolocalestring-togmtstring-y-gettime-ejemplos-cu00924c&catid=58:curso-lenguaje-programacion-java-nivel-avanzado-i&Itemid=180
                Date d1 = new Date(114,10,16);
                Date d2 = new Date(114,11,20);
                Date d3 = new Date(114,10,17);
                prestamos pres = new prestamos("48570441G", "978-84-9892-412-1", d1, d2, null);
                prestamos presMod = new prestamos("48570441G", "978-84-9892-412-1", d1, d2, d3);

                // Inserta:
                //System.out.println("Insertada/s " + myBIB.insertar(pres) + " fila/s");

                // Modifica:
                //System.out.println("Modificada/s " + myBIB.modificar(presMod) + " fila/s");

                // Borra:
                //System.out.println("Borrada/s " + myBIB.borrar(pres) + " fila/s");

                // Consulta todos los préstamos
                //ArrayList<prestamos> prest = myBIB.consultaAllPres();
                //for (prestamos p : prest) {
                //    System.out.println(p.toString()); 
                //}

            // </editor-fold>


            // <editor-fold defaultstate="collapsed" desc="Pruebas Punto 5">

                // Consulta los libros prestados en este momento
                //ArrayList<libros> libList = myBIB.consultaLibrosPrestados();
                //for (libros l : libList) {
                //    System.out.println("Título:         " + l.getTitulo());
                //    System.out.println("Autor:          " + l.getAutor());
                //    System.out.println("ISBN:           " + l.getIsbn());
                //    System.out.println("Año:            " + l.getAnno_edicion());
                //    System.out.println("Editorial:      " + l.getEditorial());
                //    System.out.println("Páginas:        " + l.getN_paginas());
                //    System.out.println("Num Ejemplares: " + l.getN_ejemplares());
                //    System.out.println("-----------------------");
                //}


                // Número de libros prestados al socio 48570440Y
                //System.out.println("Socio 48570440Y: " + myBIB.consultaNumeroLibros(myBIB.consultaSoc("48570440Y")));


                // Consulta los libros excedidos en este momento (o que hayan estado excedidos)
                //ArrayList<libros> libList = myBIB.consultaLibrosExcedidos();
                //for (libros l : libList) {
                //    System.out.println("Título:         " + l.getTitulo());
                //    System.out.println("Autor:          " + l.getAutor());
                //    System.out.println("ISBN:           " + l.getIsbn());
                //    System.out.println("Año:            " + l.getAnno_edicion());
                //    System.out.println("Editorial:      " + l.getEditorial());
                //    System.out.println("Páginas:        " + l.getN_paginas());
                //    System.out.println("Num Ejemplares: " + l.getN_ejemplares());
                //    System.out.println("-----------------------");    
                //}


                // Consulta los socios con libros excedidos en este momento
                //ArrayList<socios> soc = myBIB.consultaSociosExcedidos();
                //for (socios s : soc) {
                //    System.out.println("Nmbre:      " + s.getNombre());
                //    System.out.println("Apellido/s: " + s.getApellidos());
                //    System.out.println("DNI:        " + s.getDni());
                //    System.out.println("Dirección:  " + s.getDireccion());
                //    System.out.println("Edad:       " + s.getEdad());
                //    System.out.println("Teléfono:   " + s.getTelefono());
                //    System.out.println("-----------------------");  
                //}

            // </editor-fold>
        
            
            myBIB.cerrar();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }

        

    }
    
}
