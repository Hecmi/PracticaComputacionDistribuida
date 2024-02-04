/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas;

import com.mycompany.ventas.distribuidas.remote.ClienteRemote;
import com.mycompany.ventas.distribuidas.rmi.ClienteRmi;
import com.mycompany.ventas.distribuidas.rmi.ProductoRmi;
import com.mycompany.ventas.distribuidas.rmi.VentaRmi;
import com.mycompany.ventas.distribuidas.rpc.RpcControlador;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUIS CASANOVA
 */
public class RmiManager {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","26.48.208.162");
        
        try {
            ClienteRmi clienteRmi = new ClienteRmi();
            ProductoRmi productoRmi = new ProductoRmi();
            VentaRmi ventaRmi = new VentaRmi();
            
            Registry registry = LocateRegistry.createRegistry(8081);
            registry.rebind("Clientes", clienteRmi);
            registry.rebind("Producto", productoRmi);
            registry.rebind("Venta", ventaRmi);
            
            System.out.println("Servidor RMI listo");
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(RmiManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
