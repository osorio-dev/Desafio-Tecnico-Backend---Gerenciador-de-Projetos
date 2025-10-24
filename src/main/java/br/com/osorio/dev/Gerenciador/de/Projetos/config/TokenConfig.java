package br.com.osorio.dev.Gerenciador.de.Projetos.config;

import br.com.osorio.dev.Gerenciador.de.Projetos.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    @Value("${API_SECRET_KEY}")
    private String secretKey;

    public String generateToken(UserEntity user) {

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withIssuer("ApiSecurity")
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT decoded = JWT.require(algorithm)
                    .build().verify(token);

            return Optional.of(new JWTUserData(decoded.getClaim("userId").asLong(), decoded.getSubject()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
