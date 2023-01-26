package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cantidad {
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  private String cantidad;

}
