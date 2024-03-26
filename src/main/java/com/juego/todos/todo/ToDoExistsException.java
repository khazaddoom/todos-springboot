package com.juego.todos.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class ToDoExistsException extends RuntimeException {
    public ToDoExistsException() {
        super("ToDo already exists exception!");
    }
}
