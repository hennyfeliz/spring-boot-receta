package com.example.demo.Controller;

import com.example.demo.Entity.Cantidad;
import com.example.demo.Repository.ICantidadRepository;
import com.example.demo.Service.Impl.CantidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Cantidad")
public class CantidadController {

  @Autowired
  private ICantidadRepository cantidadRepository;

  @Autowired
  private CantidadServiceImpl cantidadService;

  @GetMapping("/")
  public List<Cantidad> getAll(){
    return cantidadService.getAll();
  }


}
