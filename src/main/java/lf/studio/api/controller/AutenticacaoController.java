package lf.studio.api.controller;


import jakarta.validation.Valid;
import lf.studio.api.domain.infra.security.ServicoToken;
import lf.studio.api.domain.infra.security.TokenDadosJWT;
import lf.studio.api.domain.usuario.DadosLogin;
import lf.studio.api.domain.usuario.UsuarioEntity;
import lf.studio.api.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class AutenticacaoController {

    //essa AuthenticationManager não precisa criar um repository ela ja é um metodo do Spring
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ServicoToken service;

    @Autowired
    private UsuarioService usuarioService;

    //puxa os dados da Api no body de login, cria um Token com a classe new Username que ja vem no authentication.
    //coloca o login é a senha.
    //gera um token do ServicoToken, faz o Cast para um Usuario e Pega as informações da autenticação.
    // e retorna um response entity passando os dados do Token.
    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosLogin dados) {

        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var autentication = manager.authenticate(token);
        var tokenJWT = service.gerarToken((UsuarioEntity) autentication.getPrincipal());
        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody @Valid UsuarioEntity usuario) {
        UsuarioEntity usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuarioCadastrado);
    }



}