package com.example.demo.Service.impl;

import com.example.demo.Entity.Cantidad;
import com.example.demo.Service.CantidadService;
import com.example.demo.dao.CantidadRepository;
import com.example.demo.dto.CantidadDTO;
import com.example.demo.mapper.CantidadMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CantidadServiceImpl implements CantidadService {
  private final CantidadRepository repository;

  public CantidadServiceImpl(CantidadRepository repository) {
    this.repository = repository;
  }

  @Override
  public Cantidad save(Cantidad entity) {
    return repository.save(entity);
  }

  @Override
  public List<Cantidad> save(List<Cantidad> entities) {
    return (List<Cantidad>) repository.saveAll(entities);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<Cantidad> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Cantidad> findAll() {
    return (List<Cantidad>) repository.findAll();
  }

  @Override
  public Page<Cantidad> findAll(Pageable pageable) {
    Page<Cantidad> entityPage = repository.findAll(pageable);
    List<Cantidad> entities = entityPage.getContent();
    return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
  }

  @Override
  public Cantidad update(Cantidad entity, Long id) {
    Optional<Cantidad> optional = findById(id);
    if (optional.isPresent()) {
      return save(entity);
    }
    return null;
  }
}