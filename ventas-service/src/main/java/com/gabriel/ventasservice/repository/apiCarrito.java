package com.gabriel.ventasservice.repository;

import com.gabriel.ventasservice.dto.CarritoDTO;
import com.gabriel.ventasservice.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "carritos-service")
public interface apiCarrito {

    @GetMapping("/carritos/total/{id_carrito}")
    public Double precioTotalCarrito(@PathVariable Long id_carrito);

    @GetMapping("/carritos/prodcutos/{id_carrito}")
    public List<ProductoDTO> prodcutosCarrito(@PathVariable Long id_carrito);

    @GetMapping("/carritos/{id_carrito}")
    public CarritoDTO carrito(@PathVariable Long id_carrito);

}