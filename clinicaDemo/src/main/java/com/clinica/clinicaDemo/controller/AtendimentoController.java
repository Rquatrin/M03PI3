package com.clinica.clinicaDemo.controller;

import ch.qos.logback.core.model.Model;
import com.clinica.clinicaDemo.model.Atendimento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtendimentoController {
       @GetMapping("/index") //eh definido a URL que sera chamada
    public String inicio() {
        return "index"; //sera apontado o arquivo HTML que sera chamado
    }

    @GetMapping("/cadastrarAtendimento") //eh definido a URL que sera chamada
    public String cadastroForm(Model model) {
        /*model.addAttribute("atendimento", new Atendimento());*/
        return "cadastrar"; //sera apontado o arquivo HTML que sera chamado
    }

    @GetMapping("/agenda") //eh definido a URL que sera chamada
    public String listaForm(Model model) {
        /*model.addAttribute("lista", atendimentoService.listarTodos());*/
        return "tabelaCadastro"; //sera apontado o arquivo HTML que sera chamado
    }
}





 