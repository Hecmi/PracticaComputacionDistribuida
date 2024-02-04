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
public class VentaDto {
    Integer id_venta;
    Integer id_producto;
    String id_cliente;
    Float cantidad;
    Float subtotal;
    Float total;
    Float impuesto_aplicado;
    Float descuento_aplicado;
    String fecha_venta;

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getImpuesto_aplicado() {
        return impuesto_aplicado;
    }

    public void setImpuesto_aplicado(Float impuesto_aplicado) {
        this.impuesto_aplicado = impuesto_aplicado;
    }

    public Float getDescuento_aplicado() {
        return descuento_aplicado;
    }

    public void setDescuento_aplicado(Float descuento_aplicado) {
        this.descuento_aplicado = descuento_aplicado;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    public void parsearJSONaDTO(JsonObject json) {    
        System.out.println(json.toString());
        this.setId_venta(Integer.parseInt(Conversiones.JsonToString(json,"id_venta")));
        this.setId_producto(Integer.valueOf(Conversiones.JsonToString(json,"id_producto")));
        this.setId_cliente(Conversiones.JsonToString(json,"id_cliente"));
        this.setCantidad(Float.parseFloat(Conversiones.JsonToString(json,"cantidad")));
        this.setSubtotal(Float.parseFloat(Conversiones.JsonToString(json,"subtotal")));
        this.setTotal(Float.parseFloat(Conversiones.JsonToString(json,"total")));
        this.setImpuesto_aplicado(Float.parseFloat(Conversiones.JsonToString(json,"impuesto_aplicado")));
        this.setDescuento_aplicado(Float.parseFloat(Conversiones.JsonToString(json,"descuento_aplicado")));
        this.setFecha_venta(Conversiones.JsonToString(json,"fecha_venta"));
    }
    
    public JsonObject parsearDTOaJSON() {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(this).getAsJsonObject();
        return jsonObject;
    }
    
    public JsonObject getJSONSubir() {
        JsonObject jsonVenta = Conversiones.crearJSONdata(this.parsearDTOaJSON());
        System.out.println(jsonVenta.toString());
        return jsonVenta;
    }
}
