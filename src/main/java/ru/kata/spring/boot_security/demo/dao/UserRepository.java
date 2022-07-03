package ru.kata.spring.boot_security.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(long id);

    User findUserById(long id);

    UserDetails findUserByUsername(String username);

    User findByUsername(String username);

}
