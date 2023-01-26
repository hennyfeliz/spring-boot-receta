package com.example.demo.Service.Impl;

import com.example.demo.Entity.Cantidad;
import com.example.demo.Repository.ICantidadRepository;
import com.example.demo.Service.ICantidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CantidadServiceImpl implements ICantidadService {

  @Autowired
  private ICantidadRepository cantidadRepository;


  @Override
  public List<Cantidad> getAll() {
    return cantidadRepository.findAll();
  }

}
