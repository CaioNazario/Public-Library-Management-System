package com.example.library_api.repository;

import com.example.library_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByEmail(String email);

    boolean existsByEmail(String Email);

    boolean existsByCpf(String cpf);
}
