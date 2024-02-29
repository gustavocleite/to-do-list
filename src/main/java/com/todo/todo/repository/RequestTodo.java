package com.todo.todo.repository;

import com.todo.todo.entity.Prioridade;
import com.todo.todo.entity.StatusTarefa;

public record RequestTodo(
    String id,
    String nome,
    String descricao,
    StatusTarefa statusTarefa,
    Prioridade prioridade
){

}
