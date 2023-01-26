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
import com.example.demo.dto.CantidadDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Cantidad API")
public interface CantidadController {
  @ApiOperation("Add new data")
  public CantidadDTO save(@RequestBody CantidadDTO cantidad);

  @ApiOperation("Find by Id")
  public CantidadDTO findById(@PathVariable("id") Long id);

  @ApiOperation("Delete based on primary key")
  public void delete(@PathVariable("id") Long id);

  @ApiOperation("Find all data")
  public List<CantidadDTO> list();

  @ApiOperation("Pagination request")
  public Page<CantidadDTO> pageQuery(Pageable pageable);

  @ApiOperation("Update one data")
  public CantidadDTO update(@RequestBody CantidadDTO dto, @PathVariable("id") Long id);
}
