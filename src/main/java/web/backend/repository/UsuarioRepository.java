package web.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
}
