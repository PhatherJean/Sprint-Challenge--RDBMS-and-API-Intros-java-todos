package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todo", allowSetters = true)
    private User users;


    public Todos()
    {
        //JPA use
    }


    public Todos(User users, String description, boolean completed)
    {
        this.description = description;
        this.completed = completed;
        this.users = users;
    }

    public Todos(User user, String description)
    {
        super();
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        boolean toggle = completed == true ? true : false;
        this.completed = toggle;
    }

    public User getUsers()
    {
        return users;
    }

    public void setUsers(User users)
    {
        this.users = users;
    }


}
