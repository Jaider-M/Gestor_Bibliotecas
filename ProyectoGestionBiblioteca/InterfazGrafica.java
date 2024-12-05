import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfazGrafica {
    private Biblioteca biblioteca;
    private JFrame frame;
    private JTextArea textArea;
    private JTextField txtTitulo, txtAutor, txtNombreUsuario, txtEmail, txtTelefono;

    public InterfazGrafica(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.frame = new JFrame("Gestion de Biblioteca");
        this.textArea = new JTextArea(20, 40); //Tamaño del textArea por #columnas y filas
        this.textArea.setEditable(false); //textArea no es editable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500); //Establece el tamaño
        frame.setLayout(new BorderLayout()); //Establece los bordes
        frame.setLocationRelativeTo(null); //Para centrar en pantalla
        frame.setResizable(false);

        // Panel de texto para mostrar resultados
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones y formularios
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(18, 1));

        // Formulario para agregar libro
        panel.add(new JLabel("Título del Libro:"));
        txtTitulo = new JTextField();
        panel.add(txtTitulo);

        panel.add(new JLabel("Autor del Libro:"));
        txtAutor = new JTextField();
        panel.add(txtAutor);

        panel.add(new JLabel("Categoría del Libro:"));
        JComboBox<Categoria> comboCategoria = new JComboBox<>(Categoria.values());
        panel.add(comboCategoria);

        // Botón para agregar libro
        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                Categoria categoria = (Categoria) comboCategoria.getSelectedItem();

                if (!titulo.isEmpty() && !autor.isEmpty() && categoria != null) {
                    Libro libro = new Libro(titulo, autor, categoria);
                    biblioteca.agregarLibro(libro);
                    textArea.append("Libro agregado: " + libro.toString() + "\n");
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
                }
            }
        });
        panel.add(btnAgregarLibro);

        // Formulario para agregar usuario
        panel.add(new JLabel("Nombre del Usuario:"));
        txtNombreUsuario = new JTextField();
        panel.add(txtNombreUsuario);

        panel.add(new JLabel("Email del Usuario:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Teléfono del Usuario:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        // Agregar Usuario
        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombreUsuario.getText();
                String email = txtEmail.getText();
                String telefono = txtTelefono.getText();

                if (!nombre.isEmpty() && !email.isEmpty() && !telefono.isEmpty()) {
                    Usuario usuario = new Usuario(nombre, email, telefono);
                    biblioteca.agregarUsuario(usuario);
                    textArea.append("Usuario agregado: " + usuario.toString() + "\n");
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
                }
            }
        });
        panel.add(btnAgregarUsuario);

        // Prestar libro
        JButton btnPrestarLibro = new JButton("Prestar Libro");
        btnPrestarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(frame, "Título del libro a prestar:");
                String nombreUsuario = JOptionPane.showInputDialog(frame, "Nombre del usuario:");

                Usuario usuario = null;
                for (Usuario u : biblioteca.getUsuarios()) {
                    if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                        usuario = u;
                        break;
                    }
                }

                if (usuario != null) {
                    String mensaje = biblioteca.prestarLibro(titulo, usuario);
                    textArea.append(mensaje + "\n");
                } else {
                    textArea.append("Usuario no encontrado.\n");
                }
            }
        });
        panel.add(btnPrestarLibro);

        // Devolver libro
        JButton btnDevolverLibro = new JButton("Devolver Libro");
        btnDevolverLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(frame, "Título del libro a devolver:");
                String mensaje = biblioteca.devolverLibro(titulo);
                textArea.append(mensaje + "\n");
            }
        });
        panel.add(btnDevolverLibro);

        // Consultar disponibilidad
        JButton btnConsultarDisponibilidad = new JButton("Consultar Disponibilidad");
        btnConsultarDisponibilidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(frame, "Título del libro a consultar:");
                String mensaje = biblioteca.consultarDisponibilidad(titulo);
                textArea.append(mensaje + "\n");
            }
        });
        panel.add(btnConsultarDisponibilidad);

        frame.add(panel, BorderLayout.EAST);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        new InterfazGrafica(biblioteca);
    }
}
