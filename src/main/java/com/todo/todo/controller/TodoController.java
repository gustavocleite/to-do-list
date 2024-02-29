package com.todo.todo.controller;

import com.todo.todo.repository.RequestTodo;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity listTodo(){
        return todoService.listTodo();
    }
    @PostMapping
    public ResponseEntity createTodo(@RequestBody RequestTodo requestBody) {
        return todoService.createTodo(requestBody);
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateTodo(@RequestBody RequestTodo requestTodo){
        return todoService.updateTodo(requestTodo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletTodo(@PathVariable String id) {
        return todoService.deletTodo(id);
    }
}
