/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventas.distribuidas.rpc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 *
 * @author LUIS CASANOVA
 */
public class RpcControlador {
    String urlConexion;    
    String host;
    Integer puerto;    
    Boolean esConexionServidor;    
    XmlRpcClient cliente;
    
    public RpcControlador(String urlConexion){        
        this.urlConexion = urlConexion;
        this.cliente = new XmlRpcClient();          
        this.esConexionServidor = false;
    }
    
    public RpcControlador(String host, Integer puerto){
        this.host = host;
        this.puerto = puerto;
        this.urlConexion = "http://" + host + ":" + puerto;        
        this.esConexionServidor = true;
    }
    
    public Boolean verificarConexion(String urlConexion) {
        URL url;
        try {
            //Realizar una conexión a la dirección para verificar si está activa
            url = new URL(urlConexion);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            int respCode = connection.getResponseCode();            
            //Si el código resultante es 200, existe una conexión valida
            if (respCode == 200) return true;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(RpcControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RpcControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean verificarConexion(String host, Integer puerto) {
        try (Socket s = new Socket(host, puerto)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public Boolean configurarRPC() {
        try {
            //Verificar si es posible realizar una conexión al servidor o a una url específica
            Boolean conexionEstablecida = false;
            if (this.esConexionServidor)
                conexionEstablecida = verificarConexion(this.host, this.puerto);
            else
                conexionEstablecida = verificarConexion(this.urlConexion);                       
            //Configurar el cliente con la url enviada por parámetro
            this.cliente = new XmlRpcClient();
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(this.urlConexion));
            this.cliente.setConfig(config);
            
            return true;
        } catch (MalformedURLException ex) {
            Logger.getLogger(RpcControlador.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }
    
    public Object ejecutarProcSimp(String procedimiento, List<Object> parametros) {                      
        try {            
            //Ejecutar el procedimiento ubicado en el servidor, retornando un solo objeto
            Object result = this.cliente.execute(procedimiento,parametros);
            return result;
        } catch (XmlRpcException ex) {
            Logger.getLogger(RpcControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Object [] ejecutarProcMul(String procedimiento, List<Object> parametros) {                      
        try {
            //Ejecutar el procedimiento ubicado en el servidor, retornando un array de objetos
            Object [] result = (Object[]) this.cliente.execute(procedimiento,parametros);            
            return result;
        } catch (XmlRpcException ex) {
            Logger.getLogger(RpcControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
