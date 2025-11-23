package web.backend.controller;

import org.springframework.web.bind.annotation.*;
import web.backend.dto.UsuarioDTO;
import web.backend.model.Usuario;
import web.backend.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario criar(@RequestBody UsuarioDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}