package com.example.storedatademo.model;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="listEnt_id",nullable = false)
    private ListEnt listEnt;


    public Task() {
    }

    public Task(Long id, String name, ListEnt listEnt) {
        this.id = id;
        this.name = name;
        this.listEnt = listEnt;
    }


    public Task(String name, ListEnt listEnt) {
        this.name = name;
        this.listEnt = listEnt;
    }

    public Task(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ListEnt getListEnt() {
        return listEnt;
    }

    public void setListEnt(ListEnt listEnt) {
        this.listEnt = listEnt;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listEnt=" + listEnt +
                '}';
    }
}


