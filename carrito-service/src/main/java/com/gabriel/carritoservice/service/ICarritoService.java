package com.gabriel.carritoservice.service;

import com.gabriel.carritoservice.dto.CarritoDTO;
import com.gabriel.carritoservice.model.Carrito;

import java.util.List;

public interface ICarritoService {

    public CarritoDTO getCarrito(Long id);
    public void saveCarrito(Carrito carrito);
    public void editCarrito(Carrito carrito);
    public void deleteCarrito(Long id);
    public List<Carrito> getCarritos();

}
