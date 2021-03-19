package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    TodoRepository todorepos;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        todorepos.findById(todoid)
                .orElseThrow(()-> new EntityNotFoundException("Todo "+ todoid + " Not Found!"));
        //todorepos.findById(todoid).get().setCompleted(true);
        todorepos.deleteById(todoid);
    }
}
