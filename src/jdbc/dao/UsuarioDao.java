package jdbc.dao;

import jdbc.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection con;

    public UsuarioDao(Connection con){ this.con = con; }

    public Usuario buscarUsuario(Usuario usuario)
    {
        Usuario autenticar = new Usuario();
        try {

           final PreparedStatement statement = con.prepareStatement("SELECT Id,usuario_nombre,contraseña" +
                   " from Usuario where usuario_nombre = ? and contraseña = ?");

           try(statement) {
               statement.setString(1,usuario.getUsuario());
               statement.setString(2,usuario.getContraseña());
               statement.execute();

               final ResultSet resultSet = statement.getResultSet();
               try(resultSet){
                   while(resultSet.next()){

                       autenticar.setId(resultSet.getInt("Id"));
                       autenticar.setUsuario(resultSet.getString("usuario_nombre"));
                       autenticar.setContraseña(resultSet.getString("contraseña"));
                   }

               }
           }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return autenticar;

    }
}
