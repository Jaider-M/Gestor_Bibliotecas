import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    // Métodos para agregar libros y usuarios
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Métodos de préstamo y devolución de libros
    public String prestarLibro(String titulo, Usuario usuario) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.prestar()) {
                    return "Libro '" + titulo + "' prestado a " + usuario.getNombre();
                }
                return "El libro '" + titulo + "' no está disponible para préstamo.";
            }
        }
        return "Libro '" + titulo + "' no encontrado.";
    }

    public String devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.devolver()) {
                    return "Libro '" + titulo + "' devuelto correctamente.";
                }
                return "El libro '" + titulo + "' ya está disponible.";
            }
        }
        return "Libro '" + titulo + "' no encontrado.";
    }

    // Método para consultar la disponibilidad de un libro
    public String consultarDisponibilidad(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isDisponible()) {
                    return "El libro '" + titulo + "' está disponible.";
                } else {
                    return "El libro '" + titulo + "' no está disponible.";
                }
            }
        }
        return "Libro '" + titulo + "' no encontrado.";
    }

    // Getter para obtener los usuarios
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Getter para obtener los libros
    public List<Libro> getLibros() {
        return libros;
    }
}

