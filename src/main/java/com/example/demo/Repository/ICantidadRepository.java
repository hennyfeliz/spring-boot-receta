package com.example.demo.Repository;

import com.example.demo.Entity.Cantidad;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICantidadRepository extends JpaRepository<Cantidad, Long> {

  @NotNull List<Cantidad> findAll();

}
