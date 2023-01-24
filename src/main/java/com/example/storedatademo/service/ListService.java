package com.example.storedatademo.service;

import com.example.storedatademo.DTO.ListDTO;
import com.example.storedatademo.DTO.ListFullDTO;
import com.example.storedatademo.model.ListEnt;
import com.example.storedatademo.repository.ListRepository;
import com.example.storedatademo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private TaskRepository taskRepository;


    public ListEnt saveList(ListEnt listEnt){

        return listRepository.save(listEnt);
    }

    public List<ListDTO> getAllLists() {
        return listRepository.getAllListDTO();
    }

    public ListDTO getList(Long id) {
        return listRepository.getListDTO(id);
    }

    public List<ListDTO> getListByUser(Long id) {

        System.out.println(listRepository.getListByUserDTO(id));

        return listRepository.getListByUserDTO(id);
    }

    public ListEnt editList(ListEnt listEnt) {
        return listRepository.save(listEnt);
    }

    public void deleteList(Long id) {
        listRepository.deleteById(id);
    }


    public List<ListFullDTO> getListDTO3Serv(Long id) {

        //1. obtener el set de list y llenar el set de task de cada uno
        List<ListFullDTO> listFullDTO = listRepository.getListDTO3(id);

        //2. setear la lista de task de cada list
        for (int i = 0; i < listFullDTO.size(); i++) {

            listFullDTO.get(i).setTasks(taskRepository.getTaskByListDTO(listFullDTO.get(i).getId()));
        }

        return listFullDTO;
    }

}
