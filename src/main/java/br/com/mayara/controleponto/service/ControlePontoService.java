package br.com.mayara.controleponto.service;

import br.com.mayara.controleponto.model.ControlePonto;
import br.com.mayara.controleponto.model.Usuario;
import br.com.mayara.controleponto.repository.ControlePontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ControlePontoService {
    @Autowired
    private ControlePontoRepository controlePontoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public void SalvarPontoUsuario(ControlePonto ponto){
        Optional<Usuario> usuarioExiste = usuarioService.consultarUsuarioPorId(ponto.getUsuario().getIdUsuario());
        if(usuarioExiste.isPresent()) {
            controlePontoRepository.save(ponto);
        }
    }

    public List<ControlePonto> PegarPontoUsuario(Integer idUsuario){
        return controlePontoRepository.findAllByUsuarioIdUsuario(idUsuario);
    }

    public List<ControlePonto> PegarPontoPorData(Calendar dataInicio, Calendar dataFim){
        return controlePontoRepository.findAllByDataHoraBetween(dataInicio, dataFim);
    }

    public List<ControlePonto> PegarPontoUsuarioPorData(Integer idUsuario, Calendar dataInicio, Calendar dataFim){
        return controlePontoRepository.findAllByUsuarioIdUsuarioAndDataHoraBetween(idUsuario, dataInicio, dataFim);
    }
}
