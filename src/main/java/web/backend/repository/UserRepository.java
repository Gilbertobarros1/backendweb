package web.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.backend.model.User;

public interface UserRepository extends JpaRepository <User, Long> {
}
