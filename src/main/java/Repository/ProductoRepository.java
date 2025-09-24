package src.main.java.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import src.main.java.db.Conexion;
import src.main.java.models.Producto;

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
            preparedStatement.executeUpdate();
            System.out.println("Producto alamcenado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
