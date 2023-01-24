package com.example.storedatademo.controller;

import com.example.storedatademo.model.ListEnt;
import com.example.storedatademo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/list")
public class ListController {

    @Autowired
    private ListService listService;


    @PostMapping(value = "")
    public ResponseEntity<?> add(@RequestBody ListEnt list){
        return ResponseEntity.ok( listService.saveList(list));
    }


    @GetMapping("/:{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(listService.getList(id));
    }


    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long user){

        if (user == null)
            return ResponseEntity.ok(listService.getAllLists());
        else
            return ResponseEntity.ok(listService.getListByUser(user));

    }



    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody ListEnt listEnt){
        return ResponseEntity.ok(listService.editList(listEnt));
    }


    @DeleteMapping("/:{id}")
    public String delete(@PathVariable Long id){
        listService.deleteList(id);
        return "deleted";
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getDTO3(@PathVariable Long id){

        return ResponseEntity.ok(this.listService.getListDTO3Serv(id));

    }




}
