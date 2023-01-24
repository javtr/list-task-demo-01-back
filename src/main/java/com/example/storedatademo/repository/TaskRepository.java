package com.example.storedatademo.repository;

import com.example.storedatademo.DTO.ListDTO;
import com.example.storedatademo.DTO.TaskDTO;
import com.example.storedatademo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT " +
            " T.id AS id," +
            " T.name AS name," +
            " T.list_ent_id AS listId " +
            " FROM task T " +
            " WHERE T.id = :id", nativeQuery = true)
    public TaskDTO getTaskDTO(@Param("id") Long taskId);

    //get all
    @Query(value = "SELECT " +
            " T.id AS id," +
            " T.name AS name," +
            " T.list_ent_id AS listId " +
            " FROM task T ", nativeQuery = true)
    public List<TaskDTO> getAllTaskDTO();

    //get by user
    @Query(value = "SELECT " +
            " T.id AS id," +
            " T.name AS name," +
            " T.list_ent_id AS listId " +
            " FROM task T " +
            " WHERE T.list_ent_id = :id", nativeQuery = true)
    public List<TaskDTO> getTaskByListDTO(@Param("id") Long listId);

}

