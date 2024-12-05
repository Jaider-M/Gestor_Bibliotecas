public abstract class ElementoBiblioteca {
    protected String titulo;
    protected boolean disponible;

    public ElementoBiblioteca(String titulo) {
        this.titulo = titulo;
        this.disponible = true; // Por defecto, el elemento está disponible
    }
    
    //get para titulo
    public String getTitulo() {
        return titulo;
    }
    
    //ge
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String toString();
}
