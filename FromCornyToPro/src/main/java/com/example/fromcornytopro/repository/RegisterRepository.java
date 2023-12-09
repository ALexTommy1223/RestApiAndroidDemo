package com.example.fromcornytopro.repository;

import com.example.fromcornytopro.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Auth,Integer> {
    Optional<Auth> findByEmail(String email);
}
