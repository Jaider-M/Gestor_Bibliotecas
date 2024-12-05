public interface Prestable {
    boolean prestar();    // Método para prestar el libro
    boolean devolver();   // Método para devolver el libro
    String getTitulo();   // Obtener el título del libro
    boolean isDisponible(); // Verificar disponibilidad del libro
}
