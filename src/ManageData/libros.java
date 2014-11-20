package ManageData;

/**
 * @author Tomás Martínez Sempere
 * @since 05/11/2014
 */
public class libros {
    protected String titulo;
    protected String autor;
    protected String isbn;
    protected int n_paginas;
    protected int n_ejemplares;
    protected String editorial;
    protected int anno_edicion;

    public libros(String titulo, String autor, String isbn, int n_paginas, int n_ejemplares, String editorial, int anno_edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.n_paginas = n_paginas;
        this.n_ejemplares = n_ejemplares;
        this.editorial = editorial;
        this.anno_edicion = anno_edicion;
    }
    
    @Override
    public String toString() {
        return "[ " + this.getTitulo() + ", "
                + this.getAutor() + ", "
                + this.getIsbn() + ", "
                + this.getN_paginas() + ", "
                + this.getN_ejemplares() + ", "
                + this.getEditorial() + ", "
                + this.getAnno_edicion() + " ]";
    }
    
    
    // ===================
    // Getters and setters
    // ===================
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getN_paginas() {
        return n_paginas;
    }

    public void setN_paginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }

    public int getN_ejemplares() {
        return n_ejemplares;
    }

    public void setN_ejemplares(int n_ejemplares) {
        this.n_ejemplares = n_ejemplares;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnno_edicion() {
        return anno_edicion;
    }

    public void setAnno_edicion(int anno_edicion) {
        this.anno_edicion = anno_edicion;
    }
    // </editor-fold>
}
