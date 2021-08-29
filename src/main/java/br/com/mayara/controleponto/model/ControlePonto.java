package br.com.mayara.controleponto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table(name = "CONTROLE_PONTO")
@NoArgsConstructor
public class ControlePonto implements Serializable {

    @Id
    @Column(name = "ID_CONTROLE_PONTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdControlePonto;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "DATA_HORA")
    private Calendar dataHora;

    @Override
    public String toString() {
        return "ControlePonto{" +
                "IdControlePonto=" + IdControlePonto +
                ", IdUsuario=" + usuario +
                ", dataHora=" + dataHora +
                '}';
    }
}
