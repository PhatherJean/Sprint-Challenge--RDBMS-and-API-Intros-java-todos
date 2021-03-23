package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    TodoRepository todorepos;

    @Autowired
    TodosService todosService;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos todos = todorepos.findById(todoid).get();
         todos.setCompleted(true);
         todorepos.save(todos);
    }
}
