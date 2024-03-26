package com.juego.todos.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoRepository repository;

    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    
    @GetMapping
    List<ToDo> getToDos() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    ToDo getById(@PathVariable Integer id) {
        return this.repository.findById(id);
    }
}
