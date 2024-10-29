package lf.studio.api.domain.usuario;


import lf.studio.api.domain.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setSenha(senhaCriptografada);

        // Salvar o usuário no banco de dados
        return repository.save(usuario);
    }
}
