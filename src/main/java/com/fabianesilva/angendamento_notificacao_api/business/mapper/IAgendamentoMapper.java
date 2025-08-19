package com.fabianesilva.angendamento_notificacao_api.business.mapper;

import com.fabianesilva.angendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.fabianesilva.angendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.fabianesilva.angendamento_notificacao_api.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.swing.*;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraOut(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacao", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Agendamento paraEntityCancelamento(Agendamento agendamento);

}
