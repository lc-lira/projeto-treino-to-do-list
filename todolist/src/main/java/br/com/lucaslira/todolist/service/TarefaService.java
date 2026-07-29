package br.com.lucaslira.todolist.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lucaslira.todolist.dto.AtualizarStatusTarefaRequest;
import br.com.lucaslira.todolist.dto.TarefaRequest;
import br.com.lucaslira.todolist.dto.TarefaResponse;
import br.com.lucaslira.todolist.entity.Tarefa;
import br.com.lucaslira.todolist.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaResponse inserirTarefa(TarefaRequest dto) {
        Tarefa tarefa = new Tarefa(
                dto.titulo(),
                dto.descricao());

        Tarefa tarefaSalva = repository.save(tarefa);

        return TarefaResponse.tarefaDto(tarefaSalva);
    }

    public TarefaResponse buscarPorId(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        return TarefaResponse.tarefaDto(tarefa);
    }

    public Page<TarefaResponse> listarTodasTarefas(Pageable pageable) {
        return repository.findAll(pageable).map(TarefaResponse::tarefaDto);
    }

    public void deletarTarefa(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        repository.delete(tarefa);
    }

    public TarefaResponse editarTarefa(Long id, TarefaRequest request) {
        Tarefa tarefaBanco = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefaBanco.setTitulo(request.titulo());
        tarefaBanco.setDescricao(request.descricao());

        Tarefa tarefaAtualizada = repository.save(tarefaBanco);
        return TarefaResponse.tarefaDto(tarefaAtualizada);
    }

    @Transactional
    public TarefaResponse atualizarStatusTarefa(Long id, AtualizarStatusTarefaRequest novoStatus) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.alterarStatus(novoStatus.status());

        return TarefaResponse.tarefaDto(tarefa);
    }

}