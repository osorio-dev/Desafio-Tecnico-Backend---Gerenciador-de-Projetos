package br.com.osorio.dev.Gerenciador.de.Projetos.service;

import br.com.osorio.dev.Gerenciador.de.Projetos.dto.RegisterUserRequest;
import br.com.osorio.dev.Gerenciador.de.Projetos.entity.UserEntity;
import br.com.osorio.dev.Gerenciador.de.Projetos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodo chamado para verificar se existe este usuario no banco para autenticação do AuthenticationManager
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional
    public UserEntity register(RegisterUserRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.email());
        userEntity.setPassword(user.password());
        userEntity.setName(user.name());

        return userRepository.saveAndFlush(userEntity);
    }
}
