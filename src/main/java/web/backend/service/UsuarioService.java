package web.backend.service;
import org.springframework.stereotype.Service;
import web.backend.dto.UsuarioDTO;
import web.backend.model.Usuario;
import web.backend.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UsuarioService {

    private final UsuarioRepository repositorio;

    public UsuarioService(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario salvar(UsuarioDTO dto) {
        Usuario u = new Usuario(
                dto.getNome(),
                dto.getCpf(),
                dto.getTelefone(),
                dto.getSenha()
        );
        return repositorio.save(u);
    }

    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Usuario atualizar(Long id, UsuarioDTO dto) {
        Usuario u = buscarPorId(id);
        if (u == null) return null;

        u.setNome(dto.getNome());
        u.setCpf(dto.getCpf());
        u.setTelefone(dto.getTelefone());
        u.setSenha(dto.getSenha());

        return repositorio.save(u);
    }

    public void deletar(Long id) {
        repositorio.deleteById(id);
    }
}
