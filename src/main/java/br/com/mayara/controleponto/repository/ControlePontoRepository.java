package br.com.mayara.controleponto.repository;

import br.com.mayara.controleponto.model.ControlePonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface ControlePontoRepository extends JpaRepository<ControlePonto, Integer> {
    public List<ControlePonto> findAllByUsuarioIdUsuario(Integer idUsuario);
    public List<ControlePonto> findAllByDataHoraBetween(Calendar dataInicio, Calendar dataFim);
    public List<ControlePonto> findAllByUsuarioIdUsuarioAndDataHoraBetween(Integer idUsuario, Calendar dataInicio, Calendar dataFim);
}
