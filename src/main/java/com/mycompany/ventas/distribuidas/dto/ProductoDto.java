/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.dto;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycompany.ventas.distribuidas.utils.Conversiones;

/**
 *
 * @author LUIS CASANOVA
 */
public class ProductoDto {
    Integer id_producto;
    String producto;    
    String unidad_medida;
    Float precio_unitario;
    Float cantidad;   
    Float iva;
    Float descuento;
    String descripcion;
    String fecha_creacion;
    String fecha_modificacion;
    
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    
    public String getNombre_producto() {
        return producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.producto = nombre_producto;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public Float getPrecio() {
        return precio_unitario;
    }

    public void setPrecio(Float precio) {
        this.precio_unitario = precio;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public void parsearJSONaDTO(JsonObject json) {    
        System.out.println(json.toString());
        this.setId_producto(Integer.valueOf(Conversiones.JsonToString(json,"id_sucursal")));
        this.setNombre_producto(Conversiones.JsonToString(json,"producto"));        
        this.setUnidad_medida(Conversiones.JsonToString(json,"unidad_medida"));
        this.setPrecio(Float.parseFloat(Conversiones.JsonToString(json,"precio_unitario")));
        this.setCantidad(Float.parseFloat(Conversiones.JsonToString(json,"cantidad")));
        this.setIva(Float.parseFloat(Conversiones.JsonToString(json,"iva")));
        this.setDescuento(Float.parseFloat(Conversiones.JsonToString(json,"descuento")));
        this.setDescripcion(Conversiones.JsonToString(json,"descripcion"));
        this.setFecha_creacion(Conversiones.JsonToString(json,"fecha_creacion"));
        this.setFecha_modificacion(Conversiones.JsonToString(json,"fecha_modificacion"));
    }
     
    public JsonObject parsearDTOaJSON() {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(this).getAsJsonObject();
        return jsonObject;
    }
    
    public JsonObject getJSONSubir() {
        JsonObject jsonProducto = Conversiones.crearJSONdata(this.parsearDTOaJSON());
        System.out.println(jsonProducto.toString());
        return jsonProducto;
    }
}

