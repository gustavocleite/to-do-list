package com.todo.todo.service;

import com.todo.todo.entity.Todo;
import com.todo.todo.repository.RequestTodo;
import com.todo.todo.repository.TodoRepository;
import jakarta.persistence.Entity;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
