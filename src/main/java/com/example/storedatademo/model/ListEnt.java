package com.example.storedatademo.model;

import com.example.storedatademo.DTO.ListFullDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NamedNativeQuery(
        name = "getPersonLocationDTONamingQuery",
        query =
                "SELECT " +
                        " L.id AS id," +
                        " L.name AS name" +
                        " FROM list_ent L " +
                        " WHERE L.user_id = :id",
        resultSetMapping = "PersonLocationDTO2Mapping"
)


@SqlResultSetMapping(
        name = "PersonLocationDTO2Mapping",
        classes = @ConstructorResult(
                targetClass = ListFullDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class)
                }
        )
)

public class ListEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "listEnt", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Task> tasks;

    public ListEnt() {
    }

    public ListEnt(Long id, String name, User user, Set<Task> tasks) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.tasks = tasks;
    }

    public ListEnt(String name, User user, Set<Task> tasks) {
        this.name = name;
        this.user = user;
        this.tasks = tasks;
    }

    public ListEnt(Long id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "List{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
