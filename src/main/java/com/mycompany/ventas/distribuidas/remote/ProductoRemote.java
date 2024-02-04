/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ventas.distribuidas.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author LUIS CASANOVA
 */
public interface ProductoRemote extends Remote {
    String getProductos() throws RemoteException;
    String getProductoPorId(String identificador) throws RemoteException;
    String buscarProducto(String texto) throws RemoteException;
    String insertarProducto(String producto) throws RemoteException;
    String editarProducto(String producto) throws RemoteException;
    String eliminarProducto(String identificador) throws RemoteException;
}
