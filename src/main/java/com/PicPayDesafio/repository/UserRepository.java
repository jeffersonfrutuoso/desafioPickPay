package com.PicPayDesafio.repository;
import com.PicPayDesafio.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
    boolean existsByEmail(String email);
    boolean existsByDocumento(String documento);
}
