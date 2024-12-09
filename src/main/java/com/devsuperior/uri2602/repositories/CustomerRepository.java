package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.dto.*;;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Consulta SQL Raíz
    @Query(nativeQuery = true, value = "SELECT name " 
            + "FROM customers " 
            + "WHERE LOWER(state)= :state")
    List<CustomerMinProjection> search1(String state);
    
    //Consulta JPQL (neste modelo de consulta não é necessário utilizar a inteface CustomerMinProjection)
    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) " 
            + "FROM Customer obj " 
            + "WHERE LOWER(obj.state)= :state")
    List<CustomerMinDTO> search2(String state);

    

    
}
