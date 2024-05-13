package com.petlife.dominio.autenticacao.repository;


import com.petlife.dominio.autenticacao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//    @Query("SELECT u FROM Usuario u  WHERE u.email = :email")
    UserDetails findByEmail(String username);

//    boolean existsByEmailOrCpf(String email, String cpf);

}


