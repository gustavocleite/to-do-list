package com.todo.todo.entity;


import com.todo.todo.repository.RequestTodo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String descricao;
    private StatusTarefa statusTarefa;
    private Prioridade prioridade;

    public Todo(RequestTodo todo){
        this.nome = todo.nome();
        this.descricao = todo.descricao();
        this.statusTarefa = todo.statusTarefa();
        this.prioridade = todo.prioridade();
    }
}
