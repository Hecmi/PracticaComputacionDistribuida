/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.rmi;

import com.google.gson.JsonObject;
import com.mycompany.ventas.distribuidas.controlador.ClienteControlador;
import com.mycompany.ventas.distribuidas.dto.ClienteDto;
import com.mycompany.ventas.distribuidas.remote.ClienteRemote;
import com.mycompany.ventas.distribuidas.utils.Conversiones;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author LUIS CASANOVA
 */
public class ClienteRmi extends UnicastRemoteObject implements ClienteRemote {    
    ClienteControlador clienteControlador;
    
    public ClienteRmi() throws RemoteException {
        clienteControlador = new ClienteControlador();
    }
    
    @Override
    public String getClientes(){
        String clientes = clienteControlador.getClientes();           
        return clientes;
    }

    @Override
    public String getClientePorId(String identificador) throws RemoteException {
        String cliente = clienteControlador.getClientePorId(identificador);
        return cliente;
    }

    @Override
    public String buscarCliente(String texto) throws RemoteException {
        String clientes = clienteControlador.buscarCliente(texto);
        return clientes;
    }

    @Override
    public String insertarCliente(String cliente) throws RemoteException {        
        JsonObject json = Conversiones.StringToJSON(cliente);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            ClienteDto clienteDto =  new ClienteDto();
            clienteDto.parsearJSONaDTO(json_data);
            
            //Validaciones antes de enviar a la base de datos
            if (clienteDto.getIdentificacion().length() != 10){
                errores = true;
            }            
            if (clienteDto.getTelefono().length() != 10){
                errores = true;
            }
                
            if (errores == false) {
                response = clienteControlador.insertarCliente(clienteDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String editarCliente(String cliente) throws RemoteException {
        JsonObject json = Conversiones.StringToJSON(cliente);
        JsonObject json_data = json.getAsJsonObject("data");
        String [] response = {"-1", "Error", "Error"};
        
        Boolean errores = false;
        
        if (json.size() > 0){
            ClienteDto clienteDto =  new ClienteDto();
            clienteDto.parsearJSONaDTO(json_data);
            
            //Validaciones antes de enviar a la base de datos
            if (clienteDto.getIdentificacion().length() != 10){
                errores = true;
            }            
            if (clienteDto.getTelefono().length() != 10){
                errores = true;
            }
                
            if (errores == false) {
                response = clienteControlador.editarCliente(clienteDto);
            }
        }
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        return responseResultado;
    }

    @Override
    public String eliminarCliente(String identificador) throws RemoteException {
        String [] response = {"-1", "Error", "Error"};
        response = clienteControlador.eliminarCliente(identificador);
        
        String responseResultado = Conversiones.parsearResultado(response[0], response[1], response[2]);
        
        return responseResultado;
    }

}
