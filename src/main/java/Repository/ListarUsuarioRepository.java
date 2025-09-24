package src.main.java.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.main.java.db.Conexion;

public class ListarUsuarioRepository {
    public void listarUsuario() {
        String sql = "SELECT * FROM usuario";
        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet datos = preparedStatement.executeQuery();

            while (datos.next()) {
                Long id = datos.getLong("id");
                String nombre = datos.getString("nombre");
                Long edad = datos.getLong("edad");
                System.out.println("ID " + id + " Nombre: " + nombre + " Edad: " + edad);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
