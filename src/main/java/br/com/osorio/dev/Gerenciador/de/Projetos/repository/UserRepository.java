package br.com.osorio.dev.Gerenciador.de.Projetos.repository;

import br.com.osorio.dev.Gerenciador.de.Projetos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserDetails> findByEmail(String email);
}
