/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas;

import com.mycompany.ventas.distribuidas.rpc.RpcControlador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LUIS CASANOVA
 */
public class TestRpc {
    public static void main (String [] args){
        RpcControlador rpc = new RpcControlador("localhost", 9000);
        if (rpc.configurarRPC()){
            List<Object> parametros = new ArrayList<>();
            /*parametros.add("Esto es una prueba de RPC");
            Object resultado = rpc.ejecutarProcSimp("len", parametros);
            System.out.println(resultado);*/
            
            parametros.add("["
                    + "{\"id_producto\":2,\"producto\":\"pepsi cola\",\"unidad_medida\":\"lt\",\"precio_unitario\":1.25,\"cantidad\":50.00,\"iva\":12.00,\"descuento\":2.00,\"descripcion\":\"pepsio cola pa\",\"fecha_creacion\":\"2024-02-03T15:30:21.26994\",\"fecha_modificacion\":\"2024-02-03T15:30:21.26994\"}, \n"
                    + " {\"id_producto\":3,\"producto\":\"coca cola\",\"unidad_medida\":\"lt\",\"precio_unitario\":1.25,\"cantidad\":50.00,\"iva\":12.00,\"descuento\":2.00,\"descripcion\":\"coca cola pa :D\",\"fecha_creacion\":\"2024-02-03T15:31:05.371257\",\"fecha_modificacion\":\"2024-02-03T15:31:05.371257\"}]");
            
            parametros.add("precio_unitario");
            Object resultado = rpc.ejecutarProcSimp("sum_json", parametros);
            
            System.out.println(resultado);
        }       
    }
}
