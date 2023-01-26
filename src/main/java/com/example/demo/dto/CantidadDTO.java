package com.example.demo.dto;

public class CantidadDTO extends AbstractDTO<Long> {
  private Long id;
  private String cantidad;

  public CantidadDTO() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public void setCantidad(String cantidad) {
    this.cantidad = cantidad;
  }

  public String getCantidad() {
    return this.cantidad;
  }
}