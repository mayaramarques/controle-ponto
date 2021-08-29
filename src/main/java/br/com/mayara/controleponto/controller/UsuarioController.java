package br.com.mayara.controleponto.controller;

import br.com.mayara.controleponto.model.Usuario;
import br.com.mayara.controleponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity SalvarUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.salvarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> BuscarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.consultarUsuarios());
    }

    @GetMapping("login/{login}")
    public ResponseEntity<Usuario> BuscarUsuarioPorLogin(@PathVariable("login") String login){
        Optional<Usuario> usuarioOptional = usuarioService.consultarUsuarioPorLogin(login);
        if(usuarioOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Usuario> BuscarUsuarioPorId(@PathVariable("id") Integer id){
        Optional<Usuario> usuarioOptional = usuarioService.consultarUsuarioPorId(id);
        if(usuarioOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("id/{id}")
    public ResponseEntity AtualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario){
        try {
            usuarioService.AtualizarUsuario(id, usuario);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
