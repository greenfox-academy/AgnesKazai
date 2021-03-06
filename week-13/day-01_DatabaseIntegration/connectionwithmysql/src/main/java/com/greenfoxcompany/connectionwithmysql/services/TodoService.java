package com.greenfoxcompany.connectionwithmysql.services;

import com.greenfoxcompany.connectionwithmysql.models.Assignee;
import com.greenfoxcompany.connectionwithmysql.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> getAllTodos();

    List<Todo> getActiveTodos(boolean active);

    void saveTodo(Todo todo);

    void removeById(Long id);

    Optional<Todo> getTodoById(Long id);

    void updateTodo(Todo todo);

    List<Todo> searchByTitel(String title);

    List<Todo> getTodosByAssignee (Assignee assignee);

    List<Todo> searchByDueDate (String dueDate);

    List<Todo> searchByAssigneeName (String assignee);

    List<Todo> search (String search);

}
