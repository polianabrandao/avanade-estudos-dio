package me.dio.avanade_estudos_dio.domain.service;

import me.dio.avanade_estudos_dio.domain.model.User;

public interface UserService {

    //criando um metodo que retorne User
    User findById(Long id);

    User create(User userToCreate);
}
