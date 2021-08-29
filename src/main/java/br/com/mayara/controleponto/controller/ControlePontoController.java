package br.com.mayara.controleponto.controller;

import br.com.mayara.controleponto.model.ControlePonto;
import br.com.mayara.controleponto.service.ControlePontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("controle-ponto")
public class ControlePontoController {
    @Autowired
    private ControlePontoService controlePontoService;

    @PostMapping
    public ResponseEntity SalvarPonto(@RequestBody ControlePonto controlePonto){
        try{
            controlePontoService.SalvarPontoUsuario(controlePonto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<List<ControlePonto>> BuscarPontoPorId(@PathVariable("id") Integer id){
        List<ControlePonto> controlePontoList = controlePontoService.PegarPontoUsuario(id);
        if(!controlePontoList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(controlePontoList);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("datainicio/{datainicio}/datafim/{datafim}")
    public ResponseEntity<List<ControlePonto>> BuscarPontosPorData(@PathVariable("datainicio") Calendar datainicio, @PathVariable("datafim") Calendar datafim){
        List<ControlePonto> controlePontoList = controlePontoService.PegarPontoPorData(datainicio, datafim);
        if(!controlePontoList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(controlePontoList);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("id/{id}/datainicio/{datainicio}/datafim/{datafim}")
    public ResponseEntity<List<ControlePonto>> BuscarPontosPorUsuarioEData(@PathVariable("id") Integer id, @PathVariable("datainicio") Calendar datainicio, @PathVariable("datafim") Calendar datafim){
        List<ControlePonto> controlePontoList = controlePontoService.PegarPontoUsuarioPorData(id, datainicio, datafim);
        if(!controlePontoList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(controlePontoList);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
