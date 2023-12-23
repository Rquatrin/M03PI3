package com.clinica.clinicaDemo.controller;

import com.clinica.clinicaDemo.model.Atendimento;
import com.clinica.clinicaDemo.repository.AtendimentoRepository;
import com.clinica.clinicaDemo.service.AtendimentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtendimentoController {

    @Autowired

    AtendimentoService atendimentoService;

    @GetMapping("/index") //eh definido a URL que sera chamada
    public String inicio() {
        return "index"; //sera apontado o arquivo HTML que sera chamado
    }

    @GetMapping("/cadastrarAtendimento") //eh definido a URL que sera chamada
    public String cadastroForm(Model model) {
        model.addAttribute("atendimento", new Atendimento());
        return "cadastrar"; //sera apontado o arquivo HTML que sera chamado
    }

    /* @GetMapping("/agenda") //eh definido a URL que sera chamada
    public String listaForm(Model model) {
        model.addAttribute("lista", atendimentoService.listarTodos());
        return "tabelaCadastro"; //sera apontado o arquivo HTML que sera chamado
    }
     */
    @GetMapping("/agenda")
    public String listarAtendimentos(Model model) {
        List<Atendimento> atendimentos = atendimentoService.listarTodos();
        model.addAttribute("lista", atendimentos);
        return "tabelaCadastro";
    }

    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Atendimento atendimento, Model model) {
        //para usar a alteração num id específico e nao criar um modelo igual com id diferente
        if (atendimento.getId() != null) {
            atendimentoService.atualizar(atendimento.getId(), atendimento);
        } else {
            atendimentoService.criar(atendimento);
        }

        return "redirect:/agenda";
    }

    @GetMapping("/excluir")
    public String excluirAtendimento(Model model, @RequestParam String id) {
        Integer idAtendimento = Integer.parseInt(id);

        atendimentoService.excluir(idAtendimento);
        return "redirect:/agenda";
    }

    @GetMapping("/alterar")
    public String exibirAlterarAtendimento(Model model, @RequestParam String id) {
        Integer idAtendimento = Integer.parseInt(id);
        Atendimento atendimentoEncontrado = atendimentoService.buscarPorId(idAtendimento);
        model.addAttribute("atendimento", atendimentoEncontrado);
        return "alterar";
    }

    @PostMapping("/alterar/{id}")
    public String salvarAlterarAtendimento(@PathVariable Integer id, @ModelAttribute("atendimento") Atendimento atendimentoAtualizado) {
        atendimentoService.atualizar(id, atendimentoAtualizado);
        return "redirect:/agenda";
    }

//alterar Status    
    @GetMapping("/atendimento-realizado")
    public String atendimentoRealizado(Model model, @RequestParam String id) {
        Integer idAtendimento = Integer.parseInt(id);
        atendimentoService.onButtonClick(idAtendimento);

        return "redirect:/agenda";
    }

}
