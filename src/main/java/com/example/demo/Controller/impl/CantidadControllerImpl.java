package com.example.demo.Controller.impl;

import com.example.demo.Controller.CantidadController;
import com.example.demo.Entity.Cantidad;
import com.example.demo.Service.CantidadService;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.mapper.CantidadMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/cantidad")
@RestController
public class CantidadControllerImpl implements CantidadController {
  private final CantidadService cantidadService;
  private final CantidadMapper cantidadMapper;

  public CantidadControllerImpl(CantidadService cantidadService, CantidadMapper cantidadMapper) {
    this.cantidadService = cantidadService;
    this.cantidadMapper = cantidadMapper;
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CantidadDTO save(@RequestBody CantidadDTO cantidadDTO) {
    Cantidad cantidad = cantidadMapper.asEntity(cantidadDTO);
    return cantidadMapper.asDTO(cantidadService.save(cantidad));
  }

  @Override
  @GetMapping("/{id}")
  public CantidadDTO findById(@PathVariable("id") Long id) {
    Cantidad cantidad = cantidadService.findById(id).orElse(null);
    return cantidadMapper.asDTO(cantidad);
  }

  @Override
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    cantidadService.deleteById(id);
  }

  @Override
  @GetMapping
  public List<CantidadDTO> list() {
    return cantidadMapper.asDTOList(cantidadService.findAll());
  }

  @Override
  @GetMapping("/page-query")
  public Page<CantidadDTO> pageQuery(Pageable pageable) {
    Page<Cantidad> cantidadPage = cantidadService.findAll(pageable);
    List<CantidadDTO> dtoList = cantidadPage
            .stream()
            .map(cantidadMapper::asDTO).collect(Collectors.toList());
    return new PageImpl<>(dtoList, pageable, cantidadPage.getTotalElements());
  }

  @Override
  @PutMapping("/{id}")
  public CantidadDTO update(@RequestBody CantidadDTO cantidadDTO, @PathVariable("id") Long id) {
    Cantidad cantidad = cantidadMapper.asEntity(cantidadDTO);
    return cantidadMapper.asDTO(cantidadService.update(cantidad, id));
  }
}