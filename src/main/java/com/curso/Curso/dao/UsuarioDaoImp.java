package com.curso.Curso.dao;

import com.curso.Curso.models.Users;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements  UsuarioDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getUsers() {
        String query = "FROM Users";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void DeleteUser(long id) {
        Users user = entityManager.find(Users.class,id);
        entityManager.remove(user);
    }

    @Override
    public void RegisterNewUser(Users usuarionew) {
        entityManager.merge(usuarionew);
    }

    @Override
    public Users LoginUser(Users usuarioLog) {
        String query = "FROM Users WHERE apellido = :apellido";
        List<Users> lista = entityManager.createQuery(query)
                .setParameter("apellido",usuarioLog.getApellido())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }
        String PaswordHash= lista.get(0).getContraseña();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(PaswordHash,usuarioLog.getContraseña())) {
            return lista.get(0);
        }
        return null;
    }


}
