package com.example.storedatademo.repository;

import com.example.storedatademo.DTO.ListDTO;
import com.example.storedatademo.DTO.ListFullDTO;
import com.example.storedatademo.model.ListEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListRepository extends JpaRepository<ListEnt, Long> {


    //get by id
    @Query(value = "SELECT " +
            " L.id AS id," +
            " L.name AS name," +
            " L.user_id AS userId " +
            " FROM list_ent L " +
            " WHERE L.id = :id", nativeQuery = true)
    public ListDTO getListDTO(@Param("id") Long listId);

    //get all
    @Query(value = "SELECT " +
            " L.id AS id," +
            " L.name AS name," +
            " L.user_id AS userId " +
            " FROM list_ent L ", nativeQuery = true)
    public List<ListDTO> getAllListDTO();

    //get by user
    @Query(value = "SELECT " +
            " L.id AS id," +
            " L.name AS name," +
            " L.user_id AS userId " +
            " FROM list_ent L " +
            " WHERE L.user_id = :id", nativeQuery = true)
    public List<ListDTO> getListByUserDTO(@Param("id") Long userId);


    @Query(name = "getPersonLocationDTONamingQuery", nativeQuery = true)
    public List<ListFullDTO> getListDTO3(@Param("id") Long userId);


}

