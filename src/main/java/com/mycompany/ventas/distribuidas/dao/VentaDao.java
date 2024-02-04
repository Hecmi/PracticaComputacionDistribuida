/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.dao;

import com.mycompany.ventas.distribuidas.dto.VentaDto;
import com.mycompany.ventas.distribuidas.rpc.RpcControlador;
import com.mycompany.ventas.distribuidas.utils.ConexionBDD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS CASANOVA
 */
public class VentaDao {
    ConexionBDD conexion;
    RpcControlador rpc;
    
    public VentaDao(){
        conexion = new ConexionBDD();
        rpc = new RpcControlador("localhost", 9000);
        rpc.configurarRPC();
    }
    
    public Double getTotalVentas() {
        //Obtener todas las ventas registradas
        String ventas = getVentas();
        
        //Declarar los parámetros a utilizar
        List<Object> parametros = new ArrayList<>();
        parametros.add(ventas);
        parametros.add("total");
        
        //Ejecutar el procedimiento simple que retorna   la suma
        Object total = rpc.ejecutarProcSimp("sum_json", parametros);
        return (Double) total;        
    }
    
    public String getVentas() {
        String comando = String.format("Select * from func_listar_venta()");
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){            
            return tabla.getValueAt(0, 0).toString();
        }
        else {            
            return "[]";
        }
    }
    
    public String getVentaPorId(String identificador) {
        String comando = String.format("Select * from func_buscar_venta('%s', 2)", identificador);
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return tabla.getValueAt(0, 0).toString();            
        }
        else {
            return "[]";
        }    
    }
    
    public String buscarVenta(String texto_buscar) {
        String comando = String.format("Select * from func_buscar_venta('%s', 1)", texto_buscar);
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return tabla.getValueAt(0, 0).toString();            
        }
        else {
            return "[]";
        }
    }
    
    public String[] insertarVenta(VentaDto venta) {
        String comando = String.format("Select * from func_insertar_venta('%s')", venta.getJSONSubir());
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return new String [] {
                tabla.getValueAt(0, 0).toString(),
                tabla.getValueAt(0, 1).toString()
            };
        }
        else {
            return new String [] {
                "-1", "{}"
            };
        }
    }

    public String[] editarVenta(VentaDto venta) {
        String comando = String.format("Select * from func_editar_venta('%s')", venta.getJSONSubir());
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return new String [] {
                tabla.getValueAt(0, 0).toString(),
                tabla.getValueAt(0, 1).toString()
            };
        }
        else {
            return new String [] {
                "-1", "{}"
            };
        }
    }    
    
    public String[] eliminarVenta(String id_venta) {
        String comando = String.format("Select * from func_eliminar_venta('%s')", id_venta);
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return new String [] {
                tabla.getValueAt(0, 0).toString(),
                tabla.getValueAt(0, 1).toString()
            };
        }
        else {
            return new String [] {
                "-1", "{}"
            };
        }
    }
}
