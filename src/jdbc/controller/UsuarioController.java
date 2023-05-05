package jdbc.controller;

import jdbc.dao.UsuarioDao;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Usuario;

public class UsuarioController {

    private UsuarioDao usuarioDao;

    public UsuarioController(){
        var factory = new ConnectionFactory();
        this.usuarioDao = new UsuarioDao(factory.recuperaConexion());
    }
    public boolean iniciarSesion(Usuario usuario)
    {
        Usuario autenticar = usuarioDao.buscarUsuario(usuario);
        try{
            if(autenticar.getUsuario().equals(usuario.getUsuario()) && autenticar.getContraseña().equals(usuario.getContraseña()))
            {
                return true;
            }else{
                return false;
            }
        }catch(Exception e)
        {
            return false;
        }


    }
}
