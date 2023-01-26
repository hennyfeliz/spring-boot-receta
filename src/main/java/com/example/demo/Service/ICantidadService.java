package com.example.demo.Service;


import com.example.demo.Entity.Cantidad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICantidadService {

  List<Cantidad> getAll();


}
