package lf.studio.api.domain.infra.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lf.studio.api.domain.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


// um componente que chama o OncePerRequestFilter para validação do Token da API
@Component
public class SecurityFiltro extends OncePerRequestFilter {

    @Autowired
    private ServicoToken servico;

    @Autowired
    private UsuarioRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            var subject = servico.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);

            //instancia padrão do authentication
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        //chama o filtro depois o outro, se não ele não retorna nada no body da API, sempre tem que ter esse filter.
        filterChain.doFilter(request, response);

    }


    private String recuperarToken(HttpServletRequest request) {
        var authorizationheader = request.getHeader("Authorization");
        if (authorizationheader != null) {
            return authorizationheader.replace("Bearer", "").trim();
        }
        return null;
    }
}
