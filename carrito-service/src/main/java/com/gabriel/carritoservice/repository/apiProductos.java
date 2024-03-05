package com.gabriel.carritoservice.repository;

import com.gabriel.carritoservice.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="productos-service")
public interface apiProductos {

    @GetMapping("/productos/carrito")
    public List<ProductoDTO> getProductosCarrito(@RequestParam List<Long> productos);

}
