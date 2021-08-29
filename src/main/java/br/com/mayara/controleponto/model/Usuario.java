package br.com.mayara.controleponto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USUARIO")
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "NOME", length = 200, nullable = false)
    private String nome;

    @Column(name = "LOGIN", length = 50, nullable = false)
    private String login;

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
