package me.dio.avanade_estudos_dio.domain.controller;

import me.dio.avanade_estudos_dio.domain.model.User;
import me.dio.avanade_estudos_dio.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // ResponseEntity é uma classe que representa toda a resposta HTTP enviada pelo servidor para o cliente.
    //Ela permite que você personalize o status HTTP, os cabeçalhos e o corpo da resposta,
    // ao invés de apenas retornar um objeto diretamente.
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> crate(@RequestBody User userToCreate){
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated); //retorna 201 Created
    }
}
