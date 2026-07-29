package br.com.lucaslira.todolist.dto;

import br.com.lucaslira.todolist.enums.TarefaStatus;
import jakarta.validation.constraints.NotNull;

public record AtualizarStatusTarefaRequest(

    @NotNull(message = "O stautus é obrigatório") 
    TarefaStatus status) {

}
