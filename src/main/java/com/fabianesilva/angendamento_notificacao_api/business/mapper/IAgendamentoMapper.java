package com.fabianesilva.angendamento_notificacao_api.business.mapper;

import com.fabianesilva.angendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.fabianesilva.angendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.fabianesilva.angendamento_notificacao_api.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;

import javax.swing.*;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = "spring")
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraOut(Agendamento agendamento);
}
