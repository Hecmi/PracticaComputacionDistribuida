/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.dao;

import com.mycompany.ventas.distribuidas.dto.ProductoDto;
import com.mycompany.ventas.distribuidas.utils.ConexionBDD;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS CASANOVA
 */
public class ProductoDao {
    ConexionBDD conexion;
    
    public ProductoDao(){
        conexion = new ConexionBDD();
    }
    
    public String getProductos() {
        String comando = String.format("Select * from func_listar_producto()");
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){            
            return tabla.getValueAt(0, 0).toString();
        }
        else {            
            return "[]";
        }
    }
    
    public String getProductoPorId(String identificador) {
        String comando = String.format("Select * from func_buscar_producto('%s', 2)", identificador);
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return tabla.getValueAt(0, 0).toString();            
        }
        else {
            return "[]";
        }    
    }
    
    public String buscarProducto(String texto_buscar) {
        String comando = String.format("Select * from func_buscar_producto('%s', 1)", texto_buscar);
        DefaultTableModel tabla = conexion.returnRecord(comando);
        
        if (tabla.getRowCount() > 0){
            return tabla.getValueAt(0, 0).toString();            
        }
        else {
            return "[]";
        }
    }
    
    public String[] insertarProducto(ProductoDto producto) {
        String comando = String.format("Select * from func_insertar_producto('%s')", producto.getJSONSubir());
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

    public String[] editarProducto(ProductoDto producto) {
        String comando = String.format("Select * from func_editar_producto('%s')", producto.getJSONSubir());
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
    
    public String[] eliminarProducto(String id_producto) {
        String comando = String.format("Select * from func_eliminar_producto('%s')", id_producto);
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
