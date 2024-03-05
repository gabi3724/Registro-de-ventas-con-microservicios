package com.gabriel.carritoservice.service;

import com.gabriel.carritoservice.dto.CarritoDTO;
import com.gabriel.carritoservice.dto.ProductoDTO;
import com.gabriel.carritoservice.model.Carrito;
import com.gabriel.carritoservice.repository.ICarritoRepository;
import com.gabriel.carritoservice.repository.apiProductos;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    private ICarritoRepository carritoRepository;

    @Autowired
    private apiProductos apiProductos;

    @Override
    @CircuitBreaker(name="prodcutos-service", fallbackMethod = "fallbackGetProdcutosCarrito")
    public CarritoDTO getCarrito(Long id) {
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if(carrito == null) return null;
        List<Long> productosCarrito = carrito.getProductos();
        HashMap<Long, Integer> productos_cantidad = new HashMap<>();
        for(Long producto_id : productosCarrito){
            if(productos_cantidad.containsKey(producto_id)){
                productos_cantidad.put(producto_id, productos_cantidad.get(producto_id)+1);
            }
            else{
                productos_cantidad.put(producto_id, 1);
            }
        }
        List<ProductoDTO> productos = apiProductos.getProductosCarrito(productosCarrito);
        double total = 0;
        int cantidad;
        for(ProductoDTO p : productos){
            cantidad = productos_cantidad.get(p.getId());
            p.setCantidad(cantidad);
            p.setSubtotal(p.getPrecio()*cantidad);
            total += p.getSubtotal();
        }
        CarritoDTO c = new CarritoDTO(
                id,
                total,
                productos
        );
        return c;
    }

    public CarritoDTO fallbackGetProdcutosCarrito(Throwable throwable){
        return new CarritoDTO(
                9999999L,
                0.0,
                null
        );
    }

    @Override
    public void saveCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void editCarrito(Carrito carrito) {
        Carrito original = carritoRepository.findById(carrito.getId()).orElse(null);
        if(original != null){
            Carrito nuevo = new Carrito(
                    carrito.getId(),
                    carrito.getProductos()
            );
            carritoRepository.save(nuevo);
        }
    }

    @Override
    public void deleteCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public List<Carrito> getCarritos() {
        return carritoRepository.findAll();
    }

}
