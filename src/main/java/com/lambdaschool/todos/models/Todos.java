package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;


    private String description;

    @Column(nullable = false)
    private boolean completed;


    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;


    public Todos()
    {
        //JPA use
    }


    public Todos(User user, String description)
    {
        this.description = description;
        this.user = user;
    }



    public long getTodoid()
    {
        return todoid;
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

    public Todos setCompleted(boolean completed)
    {
        this.completed = completed;
        return null;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
