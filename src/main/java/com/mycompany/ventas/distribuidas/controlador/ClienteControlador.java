/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.controlador;

import com.mycompany.ventas.distribuidas.dao.ClienteDao;
import com.mycompany.ventas.distribuidas.dto.ClienteDto;

/**
 *
 * @author LUIS CASANOVA
 */
public class ClienteControlador {
    
    ClienteDao clienteDao;    
    
    public ClienteControlador(){
        clienteDao = new ClienteDao();        
    }
    
    public String[] insertarCliente(ClienteDto cliente) {
        String [] resultado = clienteDao.insertarCliente(cliente);
       
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se agregó el cliente correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la inserción del cliente.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }

    public String[] editarCliente(ClienteDto cliente) {
        String [] resultado = clienteDao.editarCliente(cliente);
               
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se editó el cliente correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la actualización del cliente.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }

    public String[] eliminarCliente(String id) {
        String [] resultado = clienteDao.eliminarCliente(id);        
        
        String estado = resultado[0];
        String consulta = resultado[1];
        String mensaje = "";
        
        if (estado.equals("1")){
            mensaje = "Se eliminó el cliente correctamente.";
        }
        else{
            mensaje = "Ocurrió un problema durante la eliminación del cliente.";
        }
        
        return new String[]{estado, consulta, mensaje};
    }
    
    public String getClientePorId(String id) {
        String resultado = clienteDao.getClientePorId(id);        
        return resultado;
    }

    public String buscarCliente(String texto_buscar) {
        String resultado = clienteDao.buscarCliente(texto_buscar);
        return resultado;
    }

    public String getClientes() {
        String resultado = clienteDao.getClientes();        
        return resultado;
    }
    
}
