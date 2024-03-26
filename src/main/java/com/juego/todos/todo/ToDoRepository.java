package com.juego.todos.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ToDoRepository {

    private final List<ToDo> todos = new ArrayList<>();

    List<ToDo> findAll() {
        return this.todos;
    }

    ToDo findById(Integer id) {
        return this.todos.stream()
                .filter(todo -> todo.id().equals(id))
                .findFirst()
                .get();
    }


    @PostConstruct
    private void initData() {
        this.todos.add(new ToDo(1, "Do dishes", LocalDateTime.now()));
        this.todos.add(new ToDo(2, "Clean floor", LocalDateTime.now()));
    }

}
