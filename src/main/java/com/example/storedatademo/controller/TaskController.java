package com.example.storedatademo.controller;

import com.example.storedatademo.model.Task;
import com.example.storedatademo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Task task){
        return ResponseEntity.ok( taskService.saveTask(task));
    }


    @GetMapping("/:{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTask(id));
    }


    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long list){

        if (list == null)
            return ResponseEntity.ok(taskService.getAllTasks());
        else
            return ResponseEntity.ok(taskService.getTaskByList(list));

    }



    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Task task){
        return ResponseEntity.ok(taskService.editTask(task));
    }


    @DeleteMapping("/:{id}")
    public String delete(@PathVariable Long id){
        taskService.deleteTask(id);
        return "deleted";
    }


}
