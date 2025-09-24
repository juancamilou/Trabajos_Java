package src.main.java.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import src.main.java.db.Conexion;
import src.main.java.models.Usuario;

public class UsuarioRepository {
    public void insertaUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre,edad) VALUES (?,?)";


        try(Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getEdad());
            preparedStatement.executeUpdate();
            System.out.println("Usuario almacenado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
