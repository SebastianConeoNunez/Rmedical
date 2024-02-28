package com.medical.Medical.dao;

import com.medical.Medical.models.Users;

import java.util.List;

public interface UsuarioDao {
    List<Users> getUsers();

    void DeleteUser(long id);

    void RegisterNewUser(Users usuarionew);

    Users LoginUser(Users usuarioLog);
}
