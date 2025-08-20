// Clase Biblioteca

// Atributos: lista de libros, lista de usuarios, registro de préstamos (con fecha de inicio y fecha límite).

// Métodos void:

// registrarLibro()

// registrarUsuario()

// prestarLibro() (validar disponibilidad y límite de 3 libros por usuario)

// devolverLibro() (calcular multa si hay retraso)

// mostrarLibrosDisponibles()

// mostrarUsuarios()

// mostrarHistorialPrestamos()

// Multas

// Si un libro se devuelve después de la fecha límite, se cobra $500 por cada día de retraso.

// Mostrar la multa en consola al devolver el libro.
package biblioteca;

import java.util.*;

public class Biblioteca {
    ArrayList<Libro> listaLibros;
    ArrayList<Usuario> listaUsuarios;
    Map<Libro, Date> registroPrestamos; // libro -> fecha de devolución

    Scanner scanner = new Scanner(System.in);

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        registroPrestamos = new HashMap<>();
    

        listaLibros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1, true));
        listaLibros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 2, true));
        listaLibros.add(new Libro("1984", "George Orwell", 3, true));
    }

    public void registrarLibro() {
        System.out.println("---- REGISTRAR LIBRO ----");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        Integer id = listaLibros.size() + 1;
        Libro nuevo = new Libro(titulo, autor, id, true);
        listaLibros.add(nuevo);
        System.out.println("\nLibro registrado con ID: " + id);
    }

    public void registrarUsuario() {
        System.out.println("---- REGISTRAR USUARIO ----");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        Integer id = listaUsuarios.size() + 1;
        Usuario u = new Usuario(nombre, id);
        listaUsuarios.add(u);
        System.out.println("\nUsuario registrado con ID: " + id);
    }

    public void prestarLibro() {
        mostrarUsuarios();
        System.out.print("Ingrese ID de usuario: ");
        Integer idUser = scanner.nextInt();
        scanner.nextLine();

        if (idUser <= 0 || idUser > listaUsuarios.size()) {
            System.out.println("\nUsuario inválido.");
            return;
        }
        Usuario usuario = listaUsuarios.get(idUser - 1);

        if (!usuario.puedePrestar()) {
            System.out.println("\nEl usuario ya tiene 3 libros.");
            return;
        }

        mostrarLibrosDisponibles();
        System.out.print("Ingrese ID del libro a prestar: ");
        Integer idLibro = scanner.nextInt();
        scanner.nextLine();

        if (idLibro <= 0 || idLibro > listaLibros.size()) {
            System.out.println("\nLibro inválido.");
            return;
        }
        Libro libro = listaLibros.get(idLibro - 1); 

        if (!libro.disponible) {
            System.out.println("\nEse libro ya está prestado.");
            return;
        }

        libro.marcarPrestado();
        usuario.agregarPrestamo(libro);

        //AQUI SI SE QUIERE PROBAR LA MULTA SE DEBE COLOCAR EL SIGUIENTE CODIGO
        // cal.add(Calendar.DAY_OF_MONTH, -7); SOLO AGREGELE UN MENOS (-) AL LADO DEL NUMERO 7 QUE SON LOS DIAS DE PLAZO QUE TIENE PARA DEVOLVER EL LIBRO

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        registroPrestamos.put(libro, cal.getTime());

        System.out.println("\nPréstamo realizado. Fecha límite: " + cal.getTime());
    }

    public void devolverLibro() {
        mostrarUsuarios();
        System.out.print("Ingrese ID de usuario: ");
        Integer idUser = scanner.nextInt();
        scanner.nextLine();

        if (idUser <= 0 || idUser > listaUsuarios.size()) {
            System.out.println("\nsuario inválido.");
            return;
        }
        Usuario usuario = listaUsuarios.get(idUser - 1);

        if (usuario.librosPrestados.isEmpty()) {
            System.out.println("\nEl usuario no tiene libros prestados.");
            return;
        }

        System.out.println("Libros prestados:");
        for (Integer i = 0; i < usuario.librosPrestados.size(); i++) {
            System.out.println(i + ". " + usuario.librosPrestados.get(i).titulo);
        }
        System.out.print("Ingrese el número del libro a devolver: ");
        Integer index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= usuario.librosPrestados.size()) {
            System.out.println("\n Opción inválida.");
            return;
        }

        Libro libro = usuario.librosPrestados.get(index);
        Date fechaLimite = registroPrestamos.get(libro);
        Date hoy = new Date();

        long diasRetraso = (hoy.getTime() - fechaLimite.getTime()) / (1000 * 60 * 60 * 24);
        if (diasRetraso > 0) {
            long multa = diasRetraso * 500;
            System.out.println("El libro tiene " + diasRetraso + " días de retraso. Multa: $" + multa);
        } else {
            System.out.println("\nDevolución realizada sin multa.");
        }

        libro.marcarDisponible();
        usuario.devolverLibro(libro);
        registroPrestamos.remove(libro);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("---- LIBROS DISPONIBLES ----");
        for (Libro l : listaLibros) {
            if (l.disponible) {
                l.mostrarDatos();
            }
        }
    }

    public void mostrarUsuarios() {
        System.out.println("---- USUARIOS ----");
        for (Usuario u : listaUsuarios) {
            u.mostrarDatos();
        }
    }

public void mostrarHistorialPrestamos() {
    System.out.println("---- HISTORIAL DE PRÉSTAMOS ----");

    if (registroPrestamos.isEmpty()) {
        System.out.println("No hay préstamos activos.");
        return;
    }

    for (Map.Entry<Libro, Date> entry : registroPrestamos.entrySet()) {
        Libro libro = entry.getKey();
        Date fechaLimite = entry.getValue();
        String nombreUsuario = "Desconocido";
        for (Usuario u : listaUsuarios) {
            if (u.librosPrestados.contains(libro)) {
                nombreUsuario = u.nombre;
                break;
            }
        }
        System.out.println("Libro: " + libro.titulo + " | Prestado a: " + nombreUsuario
                            + " | Fecha límite: " + fechaLimite);
    }
}




    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanners = new Scanner(System.in);
        Integer opcion;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar historial préstamos");
            System.out.println("0. Salir");
            opcion = scanners.nextInt();
            scanners.nextLine();

            switch (opcion) {
                case 1 -> biblioteca.registrarLibro();
                case 2 -> biblioteca.registrarUsuario();
                case 3 -> biblioteca.prestarLibro();
                case 4 -> biblioteca.devolverLibro();
                case 5 -> biblioteca.mostrarLibrosDisponibles();
                case 6 -> biblioteca.mostrarUsuarios();
                case 7 -> biblioteca.mostrarHistorialPrestamos();
                case 0 -> System.out.println(" Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        scanners.close();
    }
}