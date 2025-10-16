package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.Conexion;
import models.Producto;

public class ProductoRepository {
    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre,precio,descripcion,cantidad_pro) VALUES(?,?,?,?)";

        try {
            Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setLong(4, producto.getCantidad_pro());
            preparedStatement.setLong(5, producto.getId());
            preparedStatement.executeUpdate();
            System.out.println("Producto alamcenado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void listarProducto() {
            String sql = "SELECT * FROM producto";
            try (Connection connection = Conexion.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet datos = preparedStatement.executeQuery();
                boolean encontro = false;
                while (datos.next()) {
                    encontro = true;
                    Long id = datos.getLong("id");
                    String nombre = datos.getString("nombre");
                    Long precio = datos.getLong("precio");
                    String descripcion = datos.getString("descripcion");
                    Long cantidadPro = datos.getLong("cantidad_pro");
                    System.out.println("ID: " + id + " Nombre: " + nombre + " Precio: " + precio + " Descripción: "
                            + descripcion + " Cantidad Producto: " + cantidadPro);
                }
                if (!encontro) {
                    System.out.println("No hay productos registrados en la base de datos.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void eliminarProducto(Long id) {
        String sqlElm = "DELETE FROM producto WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlElm)) {
            preparedStatement.setLong(1, id);
            int filas = preparedStatement.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto eliminado correctamente");
            } else {
                System.out.println("No se encontró el producto con id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        public void ActualizarProducto(Producto producto) {
        String sqlAc = "UPDATE producto SET nombre = ?, precio = ?, descripcion = ?, cantidad_pro = ? WHERE id = ?";

            try (Connection connection = Conexion.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlAc)) {

                preparedStatement.setString(1, producto.getNombre());
                preparedStatement.setLong(2, producto.getPrecio());
                preparedStatement.setString(3, producto.getDescripcion());
                preparedStatement.setLong(4, producto.getCantidad_pro());
                preparedStatement.setLong(5, producto.getId());

                Integer filas = preparedStatement.executeUpdate();
                if (filas > 0) {
                    System.out.println("producto actualizado correctamente");
                } else {
                    System.out.println("No se encontró el producto con id: " + producto.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

