/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author andrea
 */
public class ServerCentral 

    extends UnicastRemoteObject
    implements InterfaceCotizador
{
    ServerCentral() throws java.rmi.RemoteException{
	super();
    }

    @Override
    public double Cotizar(String fecha){
        double dolar = 0;
        if(fecha.equals("26-06-19")){
            dolar = 6.9;
        }
        if(fecha.equals("27-06-19")){
            dolar = 6.91;
        }
        if(fecha.equals("28-06-19")){
            dolar = 6.93;
        }
        if(fecha.equals("29-06-19")){
            dolar = 6.92;
        }
        if(fecha.equals("30-06-19")){
            dolar = 6.96;
        }
        return dolar;
        
    }
     public static void main(String args[]) { 
	try {
	    ServerCentral cotizador;
	    LocateRegistry.createRegistry(1099);
	    cotizador = new ServerCentral(); 
	    Naming.bind("Cotizador", cotizador); 
            System.out.
                    
                     println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }  
    
}
