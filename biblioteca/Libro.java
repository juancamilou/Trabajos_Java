    // Clase Libro

    // Atributos: título, autor, código, disponible (boolean).

    // Métodos void: mostrarDatos(), marcarPrestado(), marcarDisponible().
    package biblioteca;

    public class Libro {
        String titulo; 
        String autor; 
        Integer codigo;
        Boolean disponible = true;

        Libro(String titulo, String autor, Integer codigo, Boolean disponible) {
            this.titulo = titulo;
            this.autor = autor;
            this.codigo = codigo;
            this.disponible = disponible;
        }

        public void mostrarDatos() {
            System.out.println("\n --------------CARACTERISTICAS LIBRO--------------");
            System.out.println("Libro: " + titulo + " | Autor: " + autor + " | Código: " + codigo );

            if (!disponible) {
                System.out.println("Estado: En prestamo");
            } else {
                System.out.println(" Estado: Disponible");
            }
        }

        public void marcarPrestado() {
            if (disponible == true) {
                disponible = false;
                System.out.println("\nSe te otorga el prestamo del libro " + titulo);
                
            }
        }

        public void marcarDisponible() {
            if (disponible == false) {
                disponible = true;
                System.out.println("\nEl libro " + titulo + " Ahora se encuentra disponible para su prestamo");
            } else {
                System.out.println("\nEl libro " + titulo + " ya se encuentra disponible");
            }
        }

    }
