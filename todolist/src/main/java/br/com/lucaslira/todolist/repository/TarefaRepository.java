package br.com.lucaslira.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lucaslira.todolist.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
