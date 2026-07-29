package br.com.lucaslira.todolist.dto;

import java.time.LocalDateTime;

import br.com.lucaslira.todolist.entity.Tarefa;
import br.com.lucaslira.todolist.enums.TarefaStatus;

public record TarefaResponse(
        Long id,
        String titulo,
        String descricao,
        boolean ativo,
        TarefaStatus status,
        LocalDateTime criadoEm) {
    
        public static TarefaResponse tarefaDto(Tarefa tarefa) {
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getAtivo(),
                tarefa.getStatus(),
                tarefa.getCriadoEm());
    }
}
