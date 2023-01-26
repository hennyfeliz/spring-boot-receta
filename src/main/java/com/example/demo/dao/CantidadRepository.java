package com.example.demo.dao;

import com.example.demo.Entity.Cantidad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantidadRepository extends PagingAndSortingRepository<Cantidad, Long> {
}