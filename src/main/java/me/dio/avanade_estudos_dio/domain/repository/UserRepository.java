package me.dio.avanade_estudos_dio.domain.repository;


import me.dio.avanade_estudos_dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// a melhor prática é criar um Repository como interface, especialmente quando usamos Spring Data JPA.
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
