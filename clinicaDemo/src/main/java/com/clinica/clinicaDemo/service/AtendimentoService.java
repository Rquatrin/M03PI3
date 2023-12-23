package com.clinica.clinicaDemo.service;

import com.clinica.clinicaDemo.model.Atendimento;
import com.clinica.clinicaDemo.repository.AtendimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    public Atendimento criar(Atendimento atendimento) {
        atendimento.setId(null);
        atendimentoRepository.save(atendimento);
        return atendimento;
    }

    public List<Atendimento> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public Atendimento buscarPorId(Integer id) {
        return atendimentoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        Atendimento atendimentoEncontrado = buscarPorId(id); //valida se existe id informado
        atendimentoRepository.deleteById(atendimentoEncontrado.getId());
    }

    public Atendimento atualizar(Integer id, Atendimento atendimentoEnviado) {
        
        
        Atendimento atendimentoEncontrado = buscarPorId(id);
        atendimentoEncontrado.setNome(atendimentoEnviado.getNome());
        atendimentoEncontrado.setTelefone(atendimentoEnviado.getTelefone());
        atendimentoEncontrado.setDataH(atendimentoEnviado.getDataH());
        atendimentoEncontrado.setPResponsavel(atendimentoEnviado.getPResponsavel());
        atendimentoRepository.save(atendimentoEncontrado);
        return atendimentoEncontrado;
    }
    //função para atualizar a variavel booleana "aRealizado"
    
    public void onButtonClick(Integer id) {
    Atendimento atendimento = buscarPorId(id);
    atendimento.setARealizado(true);
    atendimentoRepository.save(atendimento);
}

}
