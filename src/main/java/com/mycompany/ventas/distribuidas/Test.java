/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas;

import com.mycompany.ventas.distribuidas.dao.VentaDao;

/**
 *
 * @author LUIS CASANOVA
 */
public class Test {
    public static void main(String [] args){
        VentaDao venta = new VentaDao();
        Double totalVenta = venta.getTotalVentas();
        System.out.println(totalVenta);
    }
}
