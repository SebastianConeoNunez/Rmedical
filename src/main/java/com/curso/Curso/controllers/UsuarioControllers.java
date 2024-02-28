package com.curso.Curso.controllers;

import com.curso.Curso.dao.UsuarioDao;
import com.curso.Curso.models.Users;
import com.curso.Curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControllers {

    @Autowired
    private UsuarioDao us ;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuario")
    public List<Users> getUsers(@RequestHeader(value = "Authorization") String token) {
        if(!ValidarToken(token)){
            return null;
        }
        return us.getUsers();
    }

    private boolean ValidarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value = "Authorization") String token,
                           @PathVariable long id) {
        if(!ValidarToken(token)){
            return ;
        }
        us.DeleteUser(id);
    }

    @RequestMapping(value = "api/usuario",method = RequestMethod.POST)
    public void RegisterUsers(@RequestBody Users usuarionew) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuarionew.getContraseña());
        usuarionew.setContraseña(hash);
        us.RegisterNewUser(usuarionew);
    }


}



