package com.gabriel.productosservice.service;

import com.gabriel.productosservice.controller.ProductoController;
import com.gabriel.productosservice.model.Producto;

import java.util.List;

public interface IProductoService {

    public Producto getProducto(Long id);
    public void saveProducto(Producto producto);
    public void editProducto(Producto producto);
    public void deleteProducto(Long id);
    public List<Producto> getProductos();
    public List<Producto> getProductosCarrito(List<Long> productos);

}
