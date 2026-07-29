package br.com.lucaslira.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaslira.todolist.dto.AtualizarStatusTarefaRequest;
import br.com.lucaslira.todolist.dto.TarefaRequest;
import br.com.lucaslira.todolist.dto.TarefaResponse;
import br.com.lucaslira.todolist.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponse> inserirTarefa(@Valid @RequestBody TarefaRequest request) {

        TarefaResponse tarefa = service.inserirTarefa(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> buscarPorId(@PathVariable Long id) {

        TarefaResponse tarefa = service.buscarPorId(id);

        return ResponseEntity.ok(tarefa);
    }

    @GetMapping
    public ResponseEntity<Page<TarefaResponse>> listarTodasTarefas(
        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        
            Page<TarefaResponse> paginaTarefa = service.listarTodasTarefas(pageable);
            
            return ResponseEntity.ok(paginaTarefa);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> editarTarefa(@PathVariable Long id,
            @Valid @RequestBody TarefaRequest request) {

        TarefaResponse tarefa = service.editarTarefa(id, request);

        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {

        service.deletarTarefa(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TarefaResponse> atualizarStatusTarefa(
        @PathVariable Long id, @Valid @RequestBody AtualizarStatusTarefaRequest novoStatus) {
            
            TarefaResponse tarefa = service.atualizarStatusTarefa(id, novoStatus);

            return ResponseEntity.ok(tarefa);
    }
}
