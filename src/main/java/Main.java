package src.main.java;

import java.util.Scanner;

import src.main.java.Repository.ListarUsuarioRepository;
import src.main.java.Repository.UsuarioRepository;
import src.main.java.models.Usuario;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ListarUsuarioRepository listarU = new ListarUsuarioRepository();

        Integer  opcion = 0;
        do {
            System.out.println("\n===== MENÚ DE USUARIOS =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("----- Registrar Usuario -----");
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese su edad: ");
                    Long edad = scanner.nextLong();
                    scanner.nextLine();

                    Usuario usuario = new Usuario(nombre, edad);
                    usuarioRepository.insertaUsuario(usuario);
                    break;

                case 2:
                System.out.println("");
                    System.out.println("Lista de Usuarios Registrados:");
                    listarU.listarUsuario();
                    break;

                case 3:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
