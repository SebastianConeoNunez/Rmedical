package com.curso.Curso.dao;

import com.curso.Curso.models.Users;

import java.util.List;

public interface UsuarioDao {
    List<Users> getUsers();

    void DeleteUser(long id);

    void RegisterNewUser(Users usuarionew);

    Users LoginUser(Users usuarioLog);
}
