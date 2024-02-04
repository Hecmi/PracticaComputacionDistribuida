/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.controlador;

import com.mycompany.ventas.distribuidas.dao.ProductoDao;
import com.mycompany.ventas.distribuidas.dto.ClienteDto;
import com.mycompany.ventas.distribuidas.dto.ProductoDto;

/**
 *
 * @author LUIS CASANOVA
 */
public class ProductoControlador {
    ProductoDao productoDao;    
    
    public ProductoControlador(){
        productoDao = new ProductoDao();        
    }
    
    public String[] insertarProducto(ProductoDto producto) {
        String [] resultado = productoDao.insertarProducto(producto);
       
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

    public String[] editarProducto(ProductoDto producto) {
        String [] resultado = productoDao.editarProducto(producto);
               
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

    public String[] eliminarProducto(String id_producto) {
        String [] resultado = productoDao.eliminarProducto(id_producto);        
        
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
    
    public String getProductoPorId(String id) {
        String resultado = productoDao.getProductoPorId(id);        
        return resultado;
    }

    public String buscarProducto(String texto_buscar) {
        String resultado = productoDao.buscarProducto(texto_buscar);
        return resultado;
    }

    public String getProductos() {
        String resultado = productoDao.getProductos();        
        return resultado;
    }
}
