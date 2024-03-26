package com.juego.todos.todo;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Optional<ToDo> found = this.repository.findById(id);
        if (found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ToDo not found!");
        }
        return found.get();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createTodo(@Valid @RequestBody ToDo todoItem) {
        Boolean todoCreated = repository.createTodo(todoItem);
        if (!todoCreated) throw new ToDoExistsException();
    }

}
