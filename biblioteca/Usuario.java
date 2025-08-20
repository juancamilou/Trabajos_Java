// Clase Usuario

// Atributos: nombre, idUsuario, lista de libros prestados (máx. 3).

// Métodos void: mostrarDatos(), agregarPrestamo(Libro), devolverLibro(Libro).

package biblioteca;

import java.util.ArrayList;

public class Usuario {
    String nombre;
    Integer idUsuario;
    ArrayList<Libro> librosPrestados;

    Usuario(String nombre, Integer idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.librosPrestados = new ArrayList<>();
    }

    public void mostrarDatos() {
        System.out.println("--------------DATOS USUARIO--------------");
        System.out.println("Nombre: " + nombre + " | ID: " + idUsuario);

        if (librosPrestados.isEmpty()) {
            System.out.println("Libros Prestados: Ninguno");
        } else {
            System.out.println("Libros Prestados:");
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.titulo);
            }
        }
    }

    public void agregarPrestamo(Libro libro) {
    if (librosPrestados.size() < 3) {  
        librosPrestados.add(libro);
        System.out.println(nombre + " ahora tiene prestado el libro: " + libro.titulo);
    } else {
        System.out.println("\n El usuario " + nombre + " ya alcanzó el máximo de préstamos (3).");
    }
}

public void devolverLibro(Libro libro) {
    librosPrestados.remove(libro);
    System.out.println(nombre + " devolvió el libro: " + libro.titulo);
}

    public boolean puedePrestar() {
    return librosPrestados.size() < 3;  
    }

    }

