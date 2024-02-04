/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ventas.distribuidas.remote;

import com.mycompany.ventas.distribuidas.dto.ClienteDto;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LUIS CASANOVA
 */
public interface ClienteRemote extends Remote {
    String getClientes() throws RemoteException;
    String getClientePorId(String identificador) throws RemoteException;
    String buscarCliente(String texto) throws RemoteException;
    String insertarCliente(String cliente) throws RemoteException;
    String editarCliente(String cliente) throws RemoteException;
    String eliminarCliente(String identificador) throws RemoteException;
}
