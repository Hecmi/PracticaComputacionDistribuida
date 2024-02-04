/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.controlador;

import com.mycompany.ventas.distribuidas.dao.ProductoDao;
import com.mycompany.ventas.distribuidas.dao.VentaDao;
import com.mycompany.ventas.distribuidas.dto.ProductoDto;
import com.mycompany.ventas.distribuidas.dto.VentaDto;

/**
 *
 * @author LUIS CASANOVA
 */
public class VentaControlador {
    VentaDao ventaDao;    
    
    public VentaControlador(){
        ventaDao = new VentaDao();        
    }
    
    public String[] insertarVenta(VentaDto venta) {
        String [] resultado = ventaDao.insertarVenta(venta);
       
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se agregó el producto correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la inserción del producto.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }

    public String[] editarVenta(VentaDto venta) {
        String [] resultado = ventaDao.editarVenta(venta);
               
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se editó el producto correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la actualización del producto.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }

    public String[] eliminarVenta(String id_venta) {
        String [] resultado = ventaDao.eliminarVenta(id_venta);        
        
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se eliminó el producto correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la eliminación del producto.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }
    
    public String getVentaPorId(String id) {
        String resultado = ventaDao.getVentaPorId(id);        
        return resultado;
    }

    public String buscarVenta(String texto_buscar) {
        String resultado = ventaDao.buscarVenta(texto_buscar);
        return resultado;
    }

    public String getVentas() {
        String resultado = ventaDao.getVentas();        
        return resultado;
    }
    
    public Double getTotalVentas(){
        Double total = ventaDao.getTotalVentas();
        return total;
    }
    
     public Double getTotalVentasPorCliente(String id_cliente){
        Double total = ventaDao.getTotalVentasPorCliente(id_cliente);
        return total;
    }
}
