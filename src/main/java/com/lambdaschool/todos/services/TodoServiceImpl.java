package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
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

    @Autowired
    private UserAuditing userAuditing;

    @Override
    public List<Todos> findAll()
    {
        List<Todos> todos = new ArrayList<>();

        todorepos.findAll()
                .iterator()
                .forEachRemaining(todos::add);

        return todos;
    }

    @Transactional
    @Override
    public Todos save(Todos todos)
    {
        if (todos.getUsers() = )
        {
            throw new EntityNotFoundException("User Todo are not updated through Todo.");
        }
        return todorepos.save(todos);
    }

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
