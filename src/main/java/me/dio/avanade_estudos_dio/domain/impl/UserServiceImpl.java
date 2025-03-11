package me.dio.avanade_estudos_dio.domain.impl;

import me.dio.avanade_estudos_dio.domain.model.User;
import me.dio.avanade_estudos_dio.domain.repository.UserRepository;
import me.dio.avanade_estudos_dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    //interface de acesso a dados
    private final UserRepository userRepository;

    //injetando o userRepository via construtor.
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()))
            throw new IllegalArgumentException("This account number already exists.");
        return userRepository.save(userToCreate);
    }
}
