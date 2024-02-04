/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.rmi;

import com.google.gson.JsonObject;
import com.mycompany.ventas.distribuidas.controlador.ProductoControlador;
import com.mycompany.ventas.distribuidas.dto.ProductoDto;
import com.mycompany.ventas.distribuidas.remote.ProductoRemote;
import com.mycompany.ventas.distribuidas.utils.Conversiones;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LUIS CASANOVA
 */
public class ProductoRmi extends UnicastRemoteObject implements ProductoRemote {

    ProductoControlador productoControlador;
    
    public ProductoRmi() throws RemoteException {
        productoControlador = new ProductoControlador();
    }
    
    @Override
    public String getProductos() throws RemoteException {
        String productos = productoControlador.getProductos();
        return productos;
    }

    @Override
    public String getProductoPorId(String identificador) throws RemoteException {
        String producto = productoControlador.getProductoPorId(identificador);
        return producto;
    }

    @Override
    public String buscarProducto(String texto) throws RemoteException {
        String productos = productoControlador.buscarProducto(texto);
        return productos;
    }

    @Override
    public String insertarProducto(String producto) throws RemoteException {
        JsonObject json = Conversiones.StringToJSON(producto);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            ProductoDto productoDto =  new ProductoDto();
            productoDto.parsearJSONaDTO(json_data);
            
            if (errores == false) {
                response = productoControlador.insertarProducto(productoDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String editarProducto(String producto) throws RemoteException {
        JsonObject json = Conversiones.StringToJSON(producto);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            ProductoDto productoDto =  new ProductoDto();
            productoDto.parsearJSONaDTO(json_data);
            
            if (errores == false) {
                response = productoControlador.editarProducto(productoDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String eliminarProducto(String identificador) throws RemoteException {
        String [] response = {"-1", "Error", "Error"};
        response = productoControlador.eliminarProducto(identificador);
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        
        return responseResultado;
    }    
}

