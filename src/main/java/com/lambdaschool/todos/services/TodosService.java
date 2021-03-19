package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

import java.util.List;

public interface TodosService
{
    List<Todos> findAll();

    Todos save(Todos todos);

    void markComplete(long todoid);
}
