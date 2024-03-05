package com.gabriel.ventasservice.service;

import com.gabriel.ventasservice.dto.VentaDTO;
import com.gabriel.ventasservice.model.Venta;

import java.util.List;

public interface IVentaService {

    public VentaDTO getVenta(Long id);
    public void saveVenta(Venta venta);
    public void editVenta(Venta venta);
    public void deleteVenta(Long id);
    public List<Venta> getVentas();

}
