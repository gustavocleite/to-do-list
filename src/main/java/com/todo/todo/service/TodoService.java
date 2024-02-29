package com.todo.todo.service;

import com.todo.todo.entity.Todo;
import com.todo.todo.repository.RequestTodo;
import com.todo.todo.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService( TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity createTodo(RequestTodo todo) {
        Todo newTodo = new Todo(todo);
        todoRepository.save(newTodo);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity listTodo(){
        var allTodo = todoRepository.findAll();
        return ResponseEntity.ok(allTodo);
    }

    public ResponseEntity updateTodo(RequestTodo requestTodo) {
        Optional<Todo> optionalTodo = todoRepository.findById(requestTodo.id());
        if( optionalTodo.isPresent()) {
            Todo todoUpdate = optionalTodo.get();
            todoUpdate.setNome(requestTodo.nome());
            todoUpdate.setDescricao(requestTodo.descricao());
            todoUpdate.setStatusTarefa(requestTodo.statusTarefa());
            todoUpdate.setPrioridade(requestTodo.prioridade());
            return ResponseEntity.ok(todoUpdate);
        }else{
            throw new EntityNotFoundException();
        }
    }

    public ResponseEntity deletTodo(String id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todoDelet = optionalTodo.get();
            todoRepository.delete(todoDelet);
            return ResponseEntity.ok("Tarefa excluida!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }
}
