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
public interface VentaRemote extends Remote {
    String getVentas() throws RemoteException;
    Double getTotalVentas() throws RemoteException;
    Double getTotalVentasPorCliente(String id_cliente) throws RemoteException;
    String getVentaPorId(String identificador) throws RemoteException;
    String buscarVenta(String texto) throws RemoteException;
    String insertarVenta(String venta) throws RemoteException;
    String editarVenta(String venta) throws RemoteException;
    String eliminarVenta(String identificador) throws RemoteException;
}
