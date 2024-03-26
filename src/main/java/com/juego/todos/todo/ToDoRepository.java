package com.juego.todos.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public class ToDoRepository {

    private final List<ToDo> todos = new ArrayList<>();

    List<ToDo> findAll() {
        return this.todos;
    }

    Optional<ToDo> findById(Integer id) {
        return this.todos.stream()
                .filter(todo -> todo.id().equals(id))
                .findFirst();
    }

    Boolean createTodo(ToDo item) {
        Optional<ToDo> found = findById(item.id());
        if (found.isPresent()) {
            return false;
        }
        this.todos.add(item);
        return true;
    }


    @PostConstruct
    @ResponseStatus(HttpStatus.CREATED)
    private void initData() {
        this.todos.add(new ToDo(1, "Do dishes", LocalDateTime.now().plusMinutes(1)));
        this.todos.add(new ToDo(2, "Clean floor", LocalDateTime.now().plusMinutes(1)));
    }

}
