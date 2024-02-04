/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.rmi;

import com.google.gson.JsonObject;
import com.mycompany.ventas.distribuidas.controlador.VentaControlador;
import com.mycompany.ventas.distribuidas.dto.ClienteDto;
import com.mycompany.ventas.distribuidas.dto.VentaDto;
import com.mycompany.ventas.distribuidas.remote.VentaRemote;
import com.mycompany.ventas.distribuidas.utils.Conversiones;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LUIS CASANOVA
 */
public class VentaRmi extends UnicastRemoteObject implements VentaRemote {

    VentaControlador ventaControlador;
    
    public VentaRmi() throws RemoteException {
        ventaControlador = new VentaControlador();
    }
    
    @Override
    public String getVentas() throws RemoteException {
        String ventas = ventaControlador.getVentas();
        return ventas;
    }

    @Override
    public String getVentaPorId(String identificador) throws RemoteException {
        String venta = ventaControlador.getVentaPorId(identificador);
        return venta;
    }

    @Override
    public String buscarVenta(String texto) throws RemoteException {
        String ventas = ventaControlador.buscarVenta(texto);
        return ventas;
    }

    @Override
    public String insertarVenta(String venta) throws RemoteException {
        JsonObject json = Conversiones.StringToJSON(venta);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            VentaDto ventaDto =  new VentaDto();
            ventaDto.parsearJSONaDTO(json_data);
            
            if (errores == false) {
                response = ventaControlador.insertarVenta(ventaDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String editarVenta(String venta) throws RemoteException {
        JsonObject json = Conversiones.StringToJSON(venta);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            VentaDto ventaDto =  new VentaDto();
            ventaDto.parsearJSONaDTO(json_data);
            
            if (errores == false) {
                response = ventaControlador.editarVenta(ventaDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String eliminarVenta(String identificador) throws RemoteException {
        String [] response = {"-1", "Error", "Error"};
        response = ventaControlador.eliminarVenta(identificador);
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        
        return responseResultado;
    }

    @Override
    public Double getTotalVentas() throws RemoteException {
        Double total_venta = ventaControlador.getTotalVentas();
        return total_venta;
    }
 
    @Override
    public Double getTotalVentasPorCliente(String id_cliente) throws RemoteException {
        Double total_venta = ventaControlador.getTotalVentasPorCliente(id_cliente);
        return total_venta;
    }
}
