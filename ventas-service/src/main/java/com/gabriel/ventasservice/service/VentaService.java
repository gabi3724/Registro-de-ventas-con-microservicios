package com.gabriel.ventasservice.service;

import com.gabriel.ventasservice.dto.CarritoDTO;
import com.gabriel.ventasservice.dto.VentaDTO;
import com.gabriel.ventasservice.model.Venta;
import com.gabriel.ventasservice.repository.VentaRepository;
import com.gabriel.ventasservice.repository.apiCarrito;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private apiCarrito apiCarrito;


    @Override
    @CircuitBreaker(name="carritos-service", fallbackMethod = "fallbackGetCarrito")
    public VentaDTO getVenta(Long id) {
        Venta v = ventaRepository.findById(id).orElse(null);
        //No encontro la venta en la base de datos
        if(v == null) return null;
        CarritoDTO lista_prodcutos = apiCarrito.carrito(v.getId_carrito());
        VentaDTO vDTO = new VentaDTO(
            id,
            v.getFecha(),
            lista_prodcutos
        );
        return vDTO;
    }

    public VentaDTO fallbackGetCarrito(Throwable throwable){
        return new VentaDTO(
                9999L,
                null,
                null
        );
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void editVenta(Venta venta) {
        Venta v = ventaRepository.findById(venta.getId()).orElse(null);
        //Si encontro la venta en la base de datos
        if(v != null){
            Venta ventaActualizada = new Venta(
                    venta.getId(),
                    venta.getFecha(),
                    venta.getId_carrito()
            );
            this.saveVenta(ventaActualizada);
        }
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }
}
