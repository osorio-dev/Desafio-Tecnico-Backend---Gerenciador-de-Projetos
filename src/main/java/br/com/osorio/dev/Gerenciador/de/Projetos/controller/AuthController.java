package br.com.osorio.dev.Gerenciador.de.Projetos.controller;

import br.com.osorio.dev.Gerenciador.de.Projetos.dto.LoginRequestDTO;
import br.com.osorio.dev.Gerenciador.de.Projetos.dto.LoginResponseDTO;
import br.com.osorio.dev.Gerenciador.de.Projetos.dto.RegisterUserRequest;
import br.com.osorio.dev.Gerenciador.de.Projetos.dto.RegisterUserResponse;
import br.com.osorio.dev.Gerenciador.de.Projetos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        // Nesta Parte é passado para criar um token de usuario com email e senha
        UsernamePasswordAuthenticationToken userAndPass =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());

        // Nesta parte é recebido o token do usuario para autenticar chamando o metodo loadUserByUsername do AuthService
        Authentication authentication = authenticationManager.authenticate(userAndPass);


        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        authService.register(request);

        return ResponseEntity.ok().build();
    }
}
