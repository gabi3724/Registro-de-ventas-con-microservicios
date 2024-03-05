package com.gabriel.ventasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    private Long id;

    private Date fecha;

    private CarritoDTO carrito;

}
