/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas;

import com.mycompany.ventas.distribuidas.remote.ClienteRemote;
import com.mycompany.ventas.distribuidas.remote.ProductoRemote;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUIS CASANOVA
 */
public class TestCliente {
    public static void main(String [] args){
        try {
            System.setProperty("java.rmi.server.hostname","26.48.208.162");

            Registry registry = LocateRegistry.getRegistry("26.48.208.162", 8081);
            ProductoRemote stub;
            stub = (ProductoRemote) registry.lookup("Producto");
            String response = stub.getProductos();
            System.out.println("Respuesta del servidor: " + response);

        } catch (NotBoundException | AccessException ex) {
            Logger.getLogger(RmiManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(TestCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
