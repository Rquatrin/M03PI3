package com.clinica.clinicaDemo.controller;

import com.clinica.clinicaDemo.model.Atendimento;
import com.clinica.clinicaDemo.service.AtendimentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/atendimento")
public class AtendimentoAPIController {
    
    @Autowired
    AtendimentoService atendimentoService;

    //cadastrar(C)
    @PostMapping("/adicionar")
    public ResponseEntity<Atendimento> addAtendimento(@RequestBody Atendimento atendimento) {
        var novoAtendimento = atendimentoService.criar(atendimento);
        return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
    }

    //listar(R)
    @GetMapping("/listar")
    public ResponseEntity<List> listar() {
        List<Atendimento> atendimentos = atendimentoService.listarTodos();
        return new ResponseEntity<>(atendimentos, HttpStatus.OK);
    }

    //buscar(R)
    //@GetMapping("/buscar/{id}")
    //public ResponseEntity<Atendimento> pesquisar(@PathVariable Integer id) {
    //    Atendimento atendimentoEncontrado = atendimentoService.buscarPorId(id);
    //    return new ResponseEntity<>(atendimentoEncontrado, HttpStatus.OK);
    //}

    //alterar(U)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Atendimento> atualizarAtendimento(@PathVariable Integer id, @RequestBody Atendimento atendimento) {
        var editarAtendimento = atendimentoService.atualizar(id, atendimento);
        return new ResponseEntity<>(editarAtendimento, HttpStatus.OK);
    }

    //excluir(D)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        atendimentoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
