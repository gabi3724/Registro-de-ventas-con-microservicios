package com.gabriel.carritoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String nombre;
    private String marca;
    private double precio;
    private int cantidad;
    private double subtotal;

}
