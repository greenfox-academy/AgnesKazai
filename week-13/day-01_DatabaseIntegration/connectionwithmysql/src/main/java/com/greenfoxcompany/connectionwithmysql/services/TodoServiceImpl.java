package com.greenfoxcompany.connectionwithmysql.services;

import com.greenfoxcompany.connectionwithmysql.models.Assignee;
import com.greenfoxcompany.connectionwithmysql.models.Todo;
import com.greenfoxcompany.connectionwithmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public List<Todo> getActiveTodos(boolean active) {
        List<Todo> todos = new ArrayList<>();
        if (active == true) {
            todoRepository.findByDoneFalse().forEach(todos::add);
        } else {
            todoRepository.findByDoneTrue().forEach(todos::add);
        }
        return todos;
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void removeById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public List<Todo> searchByTitel(String title) {
        return todoRepository.findByTitleContaining(title);
    }

    @Override
    public List<Todo> getTodosByAssignee(Assignee assignee) {
        return todoRepository.findTodosByAssignee(assignee);
    }

    @Override
    public List<Todo> searchByDueDate(String dueDate) {
        return todoRepository.findByDueDate(dueDate);
    }

    @Override
    public List<Todo> searchByAssigneeName(String assignee) {
        return todoRepository.findByAssigneeName(assignee);
    }

    @Override
    public List<Todo> search(String search) {
        List<Todo> searchResDueDate = todoRepository.findByDueDate(search);
        List<Todo> searchResAssignee = todoRepository.findByAssigneeName(search);
        List<Todo> searchResTitle = todoRepository.findByTitleContaining(search);
        if (!searchResDueDate.isEmpty()) {
            return searchResDueDate;
        } else if (!searchResAssignee.isEmpty()) {
            return searchResAssignee;
        } else if (!searchResTitle.isEmpty()) {
            return searchResTitle;
        } else {
            return getAllTodos();
        }
    }
}
