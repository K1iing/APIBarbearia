package lf.studio.api.domain.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lf.studio.api.domain.usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class ServicoToken {


    @Value("${api.security.token.secret}")
    private String secret;
    //Try catch copiado do Auth0, coloquei a var algoritimo é coloquei o tipo de Token que é o HMAC256 e criei uma variavel SECRET
    //Passei um usuario que vai ser o Token gerado.
    //o Objeto que vai ser um Login e a data que ele vai expirar e criei um metodo na classe.

    public String gerarToken(UsuarioEntity usuario) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Barbearia")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    //retornar o Subject
    public String getSubject(String TokenJWT) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("API Barbearia")
                    .build()
                    .verify(TokenJWT)
                    .getSubject();


        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token Invalido ou Expirado" + TokenJWT);

        }
    }

    //coloca o data pro brasil.
    private Instant dataExpiracao() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

