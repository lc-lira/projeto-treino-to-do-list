package br.com.lucaslira.todolist.repository;


import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lucaslira.todolist.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    Page<Tarefa> findAll(Pageable pageable);
}
