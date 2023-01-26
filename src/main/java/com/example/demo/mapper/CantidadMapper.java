package com.example.demo.mapper;

import com.example.demo.Entity.Cantidad;
import com.example.demo.dto.CantidadDTO;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CantidadMapper extends GenericMapper<Cantidad, CantidadDTO> {
  @Override
  @Mapping(target = "id", ignore = false)
  Cantidad asEntity(CantidadDTO dto);
}