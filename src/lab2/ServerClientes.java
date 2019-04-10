/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author andrea
 */
public class ServerClientes {
    public static void main(String[] args){
        int port =2027; // puerto en el que escuchara el socket
        String[] idcliente = {"1","2","3"};
        double[] saldo = {300,400,1000};
        int n_cliente = 0;
        double saldo_cliente = 0;
        try {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            Socket client;      
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            System.out.println("El servidor esta listo\n");
            while(true){   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // aceptala conexion
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena = fromClient.readLine(); //cadena obtenida desde el lector
                for(int i = 0; i <= idcliente.length; i++){
                    if(idcliente[i].equals(cadena)){
                        n_cliente = i;
                        break;
                    }
                }
                saldo_cliente = saldo[n_cliente];
                cadena = String.valueOf(saldo_cliente);
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println(cadena); 
                toClient.flush();  
                toClient.println(cadena);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
