package web.backend.service;


import org.springframework.stereotype.Service;
import web.backend.dto.UserRequestDTO;
import web.backend.dto.UserResponseDTO;
import web.backend.model.User;
import web.backend.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public UserResponseDTO save(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        repository.save(user);

        return new UserResponseDTO(user.getId(), user.getUsername());
    }

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }
}
