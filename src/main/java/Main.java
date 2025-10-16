import java.util.List;
import java.util.Scanner;

import models.Producto;
import models.Usuario;
import repository.ProductoRepository;
import repository.UsuarioRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ProductoRepository productoRepository = new ProductoRepository();
        Integer  opcion = 0;
        do {
            System.out.println("\n===== MENÚ DE USUARIOS =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Buscar usuario");
            System.out.println("6. Registrar producto");
            System.out.println("7. Listar producto");
            System.out.println("8. Actualizar producto");
            System.out.println("9. Eliminar producto");
            System.out.println("10. Salir");
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

                    Usuario usuario = new Usuario(nombre, edad);
                    usuarioRepository.insertaUsuario(usuario);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Lista de Usuarios Registrados:");
                    List<Usuario> usuarios = usuarioRepository.listaruUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() + " | Edad: " + u.getEdad());
                    }
                    break;
                case 3:
                    System.out.println("----- Actualizar Usuario -----");
                    List<Usuario> usuariosAct = usuarioRepository.listaruUsuarios();
                    for (Usuario u : usuariosAct) {
                        System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() + " | Edad: " + u.getEdad());
                    }

                    System.out.print("Ingrese el ID del usuario a actualizar: ");
                    Long idActualizar = scanner.nextLong();
                    scanner.nextLine(); 

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Ingrese la nueva edad: ");
                    Long nuevaEdad = scanner.nextLong();

                    Usuario usuarioActualizar = new Usuario(idActualizar, nuevoNombre, nuevaEdad);
                    usuarioRepository.actualizarUsuario(usuarioActualizar);

                    break;
                case 4:
                    System.out.println("----- Eliminar Usuario -----");
                    List<Usuario> usuariosElm = usuarioRepository.listaruUsuarios();
                    for (Usuario u : usuariosElm) {
                        System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() + " | Edad: " + u.getEdad());
                    }
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    Long idU = scanner.nextLong();
                    usuarioRepository.eliminarUsuario(idU);
                    break;
                case 5:
                    System.out.print("\nIngrese el id del usuario a buscar: ");
                    Long idbusqueda = scanner.nextLong();

                    Usuario encontrado = usuarioRepository.buscarUsuarioPorNombre(idbusqueda);
                    if (encontrado != null) {
                        System.out.println("Usuario encontrado: Id: " + encontrado.getId() +
                                " Nombre: " + encontrado.getNombre() +
                                " Edad: " + encontrado.getEdad());
                    } else {
                        System.out.println("No se encontró un usuario con el id: " + idbusqueda);
                    }
                    break;
                case 6:
                    System.out.println("-----Registrar producto-----");
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombrePro = scanner.nextLine();
                    System.out.println("Ingrese el valor unitario del producto: ");
                    Long precioUni = scanner.nextLong();
                    System.out.println("Ingrese una descripción corta del producto: ");
                    String descripcionPro = scanner.nextLine();
                    System.out.println("Ingrese la cantidad de productos: ");
                    Long cantidadPro = scanner.nextLong();

                    Producto producto = new Producto(nombrePro, precioUni, descripcionPro, cantidadPro);
                    productoRepository.insertarProducto(producto);
                    break;
                case 7:
                    productoRepository.listarProducto();
                    break;
                case 8:
                    System.out.println("-----Actualizar Producto-----");
                    productoRepository.listarProducto();
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    Long idActualizarPro = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombrePro = scanner.nextLine();

                    System.out.print("Ingrese el nuevo precio: ");
                    Long nuevoPrecio = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();

                    System.out.print("Ingrese la nueva cantidad: ");
                    Long nuevaCantidad = scanner.nextLong();

                    Producto productoActualizar = new Producto(idActualizarPro, nuevoNombrePro, nuevoPrecio,nuevaDescripcion, nuevaCantidad);
                    productoRepository.ActualizarProducto(productoActualizar);
                    break;

                case 9:
                    System.out.println("-----Eliminar Producto-----");
                    productoRepository.listarProducto();
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    productoRepository.eliminarProducto(idEliminar);
                    break;
                case 10:
                System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}
