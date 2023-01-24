package com.example.storedatademo.service;

import com.example.storedatademo.DTO.ListDTO;
import com.example.storedatademo.DTO.TaskDTO;
import com.example.storedatademo.model.ListEnt;
import com.example.storedatademo.model.Task;
import com.example.storedatademo.repository.ListRepository;
import com.example.storedatademo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task){

        return taskRepository.save(task);
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.getAllTaskDTO();
    }

    public TaskDTO getTask(Long id) {
        return taskRepository.getTaskDTO(id);
    }


    public List<TaskDTO> getTaskByList(Long id) {
        return taskRepository.getTaskByListDTO(id);
    }

    public Task editTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }



}
