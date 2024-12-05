public class Usuario {
    private String nombre;
    private String email;
    private String telefono;

    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    //get para nombre
    public String getNombre() {
        return nombre;
    }
    //get para email
    public String getEmail() {
        return email;
    }
    //get para telefono
    public String getTelefono() {
        return telefono;
    }
    //metodo toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono;
    }
}


