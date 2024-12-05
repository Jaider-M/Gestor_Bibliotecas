public class Libro extends ElementoBiblioteca implements Prestable {
    private String autor;
    private Categoria categoria;

    public Libro(String titulo, String autor, Categoria categoria) {
        super(titulo); //Llama al construcroe de la superclase 
        this.autor = autor;
        this.categoria = categoria;
    }
    
    //get para autor
    public String getAutor() {
        return autor;
    }
    
    //get para categoria
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean prestar() {
        if (this.isDisponible()) {
            this.setDisponible(false); // El libro ya no está disponible después de prestarlo
            return true;
        }
        return false;
    }

    @Override
    public boolean devolver() {
        if (!this.isDisponible()) {
            this.setDisponible(true); // El libro se marca como disponible
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Categoría: " + categoria;
    }
}

