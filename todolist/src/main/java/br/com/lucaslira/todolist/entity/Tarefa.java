package br.com.lucaslira.todolist.entity;

import java.time.LocalDateTime;

import br.com.lucaslira.todolist.enums.TarefaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefa")
@Getter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String titulo;

    @Setter
    private String descricao;

    private boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private TarefaStatus status = TarefaStatus.PENDENDE;

    private LocalDateTime criadoEm = LocalDateTime.now();

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Tarefa(Long id, String titulo, String descricao, boolean ativo, TarefaStatus status,
            LocalDateTime criadoEm) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ativo = ativo;
        this.status = status;
        this.criadoEm = criadoEm;
    }

    public void alterarStatus(TarefaStatus novoStatus) {
    this.status = novoStatus;
}


}
