package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import models.Usuario;

public class UsuarioRepository {
    public void insertaUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre,edad) VALUES (?,?)";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getEdad());
            preparedStatement.executeUpdate();
            System.out.println("Usuario almacenado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        String sqlAc = "UPDATE usuario SET nombre = ?, edad = ? WHERE id = ?";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlAc)) {

            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setLong(2, usuario.getEdad());
            preparedStatement.setLong(3, usuario.getId());

            Integer filas = preparedStatement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente");
            } else {
                System.out.println("No se encontró el usuario con id: " + usuario.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(Long id) {
        String sqlElm = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlElm)) {
            preparedStatement.setLong(1, id);
            int filas = preparedStatement.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente");
            } else {
                System.out.println("No se encontró el usuario con id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // -------------------LISTAR USUARIOS MAIK------------------------------------
    public List<Usuario> listaruUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";

        try (Connection connection = Conexion.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("edad")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }
    
    public Usuario buscarUsuarioPorNombre(Long id) {
        String sql = "SELECT * FROM USUARIO WHERE id = ? LIMIT 1";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("edad")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

