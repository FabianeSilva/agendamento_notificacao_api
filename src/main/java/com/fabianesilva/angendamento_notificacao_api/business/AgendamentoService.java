package com.fabianesilva.angendamento_notificacao_api.business;

import com.fabianesilva.angendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.fabianesilva.angendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.fabianesilva.angendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.fabianesilva.angendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.fabianesilva.angendamento_notificacao_api.infrastructure.exception.NotFoundException;
import com.fabianesilva.angendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento) {
        return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }

    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        repository.save(
                agendamentoMapper.paraEntityCancelamento(agendamento));
    }

}
