package com.example.storedatademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<ListEnt> listEnts;


    public User() {
    }

    public User(Long id, String name, Set<ListEnt> listEnts) {
        this.id = id;
        this.name = name;
        this.listEnts = listEnts;
    }

    public User(String name, Set<ListEnt> listEnts) {
        this.name = name;
        this.listEnts = listEnts;
    }

    public User(Long id) {
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

    public void setName(String name) {
        this.name = name;
    }

    public Set<ListEnt> getListEnts() {
        return listEnts;
    }

    public void setListEnts(Set<ListEnt> listEnts) {
        this.listEnts = listEnts;
    }

    public Set<ListEnt> getLists() {
        return listEnts;
    }

    public void setLists(Set<ListEnt> listEnts) {
        this.listEnts = listEnts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

