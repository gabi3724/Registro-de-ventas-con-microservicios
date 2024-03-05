package com.gabriel.carritoservice.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {

    private Long id;
    private Double precioTotal;
    private List<ProductoDTO> productos;

}
