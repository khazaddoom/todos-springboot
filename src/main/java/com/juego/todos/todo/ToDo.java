package com.juego.todos.todo;

import java.time.LocalDateTime;

public record ToDo(
    Integer id,
    String todoText,
    LocalDateTime createdOn
) {}