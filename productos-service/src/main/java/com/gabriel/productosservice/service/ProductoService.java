package com.gabriel.productosservice.service;

import com.gabriel.productosservice.model.Producto;
import com.gabriel.productosservice.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void editProducto(Producto producto) {
        Producto original = productoRepository.findById(producto.getId()).orElse(null);
        if(original != null){
            Producto nuevo = new Producto(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getMarca(),
                    producto.getPrecio()
            );
            productoRepository.save(nuevo);
        }
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> getProductosCarrito(List<Long> productos) {
        return productoRepository.findAllById(productos);
    }

}
