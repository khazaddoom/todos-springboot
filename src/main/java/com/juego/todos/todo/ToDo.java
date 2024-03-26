package com.juego.todos.todo;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record ToDo(
    Integer id,
    @NotEmpty
    String todoText,
    LocalDateTime createdOn
) {

    public ToDo {
        if(id < 1) {
            throw new IllegalArgumentException("id cannot be less than 1!");
        }
        if(createdOn.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("createdOn cannot be in the past!");
        }
    }

}