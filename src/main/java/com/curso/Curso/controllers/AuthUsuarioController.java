package com.curso.Curso.controllers;

import com.curso.Curso.dao.UsuarioDao;
import com.curso.Curso.models.Users;
import com.curso.Curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthUsuarioController {

    @Autowired
    private UsuarioDao us ;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String LoginUsers(@RequestBody Users usuarioLog) {
        Users answer= us.LoginUser(usuarioLog);

        if(answer != null){
            String tokenJwt = jwtUtil.create(String.valueOf(answer.getId()),answer.getApellido());
            return tokenJwt;
        }else {
            return "FAIL";
        }
    }

}
