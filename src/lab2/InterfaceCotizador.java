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
public interface InterfaceCotizador extends Remote{
    
    double Cotizar(String fecha) throws RemoteException;
}
