package com.gabriel.productosservice.controller;

import com.gabriel.productosservice.model.Producto;
import com.gabriel.productosservice.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Long id){
        System.out.println("Atendiendo peticion desde el puerto: " + serverPort);
        return productoService.getProducto(id);
    }

    @GetMapping("/all")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @PostMapping
    public void saveProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
    }

    @PutMapping
    public Producto editProducto(@RequestBody Producto producto){
        productoService.editProducto(producto);
        return productoService.getProducto(producto.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }

    @GetMapping("/carrito")
    public List<Producto> getProductosCarrito(@RequestParam List<Long> productos){
        System.out.println("Atendiendo peticion desde el puerto: " + serverPort);
        return productoService.getProductosCarrito(productos);
    }

}
