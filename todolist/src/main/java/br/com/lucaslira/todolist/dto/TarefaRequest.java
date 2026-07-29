package br.com.lucaslira.todolist.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaRequest(
    
    @NotBlank(message = "O título é obrigatório")
    String titulo,

    String descricao
) {

}
