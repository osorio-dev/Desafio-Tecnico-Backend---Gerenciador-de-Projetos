package br.com.osorio.dev.Gerenciador.de.Projetos.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(
        @NotEmpty(message = "Email Obrigatório!!") String email,
        @NotEmpty(message = "Senha Obrigatória!!") String password
) {}
