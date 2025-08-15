package com.fabianesilva.angendamento_notificacao_api.infrastructure.repositories;

import com.fabianesilva.angendamento_notificacao_api.infrastructure.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
