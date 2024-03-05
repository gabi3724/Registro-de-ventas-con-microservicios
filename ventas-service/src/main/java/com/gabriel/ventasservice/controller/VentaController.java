package com.gabriel.ventasservice.controller;

import com.gabriel.ventasservice.dto.VentaDTO;
import com.gabriel.ventasservice.model.Venta;
import com.gabriel.ventasservice.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/{id}")
    public VentaDTO getVenta(@PathVariable Long id){
        return ventaService.getVenta(id);
    }

    @GetMapping("/all")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @PostMapping
    public void saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
    }

    @PutMapping
    public VentaDTO editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
        return ventaService.getVenta(venta.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id){
        ventaService.deleteVenta(id);
    }

}
