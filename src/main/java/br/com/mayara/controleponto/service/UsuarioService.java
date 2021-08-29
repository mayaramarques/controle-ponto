package br.com.mayara.controleponto.service;

import br.com.mayara.controleponto.model.Usuario;
import br.com.mayara.controleponto.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> consultarUsuarioPorId(Integer idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<Usuario> consultarUsuarioPorLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public List<Usuario> consultarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void salvarUsuario(Usuario usuario){
        Optional<Usuario> usuarioExiste = consultarUsuarioPorLogin(usuario.getLogin());
        if(!usuarioExiste.isPresent()){
            usuarioRepository.save((usuario));
        }
    }

    public void AtualizarUsuario(Integer idUsuario, Usuario usuario){
        Optional<Usuario> usuarioExiste = consultarUsuarioPorId(idUsuario);
        if(usuarioExiste.isPresent()){
            Usuario usuarioExistente = usuarioExiste.get();
            BeanUtils.copyProperties(usuario, usuarioExistente, "idUsuario");
            usuarioRepository.save(usuarioExistente);
        }
    }
}
