package com.gabriel.carritoservice.controller;

import com.gabriel.carritoservice.dto.CarritoDTO;
import com.gabriel.carritoservice.model.Carrito;
import com.gabriel.carritoservice.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    @GetMapping("/{id}")
    public CarritoDTO getCarrito(@PathVariable Long id){
        return carritoService.getCarrito(id);
    }

    @GetMapping("/all")
    public List<Carrito> getCarritos() {
        return carritoService.getCarritos();
    }

    @PostMapping
    public void saveCarrito(@RequestBody Carrito carrito){
        carritoService.saveCarrito(carrito);
    }

    @PutMapping
    public CarritoDTO editCarrito(@RequestBody Carrito carrito){
        carritoService.editCarrito(carrito);
        return carritoService.getCarrito(carrito.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteCarrito(@PathVariable Long id){
        carritoService.deleteCarrito(id);
    }

}
