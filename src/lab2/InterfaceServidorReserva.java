/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.rmi.*;
/**
 *
 * @author andrea
 */
public interface InterfaceServidorReserva extends Remote {
    
    double Cotizar(String inicio, String fin, String fechacotizacion) throws RemoteException;
    String Reservar(String inicio, String fin, String idcliente, String fechacompra) throws RemoteException;
    
}
