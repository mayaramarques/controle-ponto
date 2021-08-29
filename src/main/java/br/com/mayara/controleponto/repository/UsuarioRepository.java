package br.com.mayara.controleponto.repository;

import br.com.mayara.controleponto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByLogin(String login);
}
