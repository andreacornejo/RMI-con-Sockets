package lab2;

import java.rmi.Naming;
import java.util.Scanner;
/**
 *
 * @author andrea
 */
public class ClienteReserva {
    
    public static void main(String args[]){
        
      InterfaceServidorReserva reserva;
      String inicio;
      String fin;
      String fechacotizacion;
      String fechacompra;
      String idcliente;
	try {
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion; 
            reserva =(InterfaceServidorReserva )Naming.lookup("rmi://localhost/Reserva");
            System.out.println("RESERVA DE HOTEL \n");    
            
            while(!salir){
            
            System.out.println("1) Cotizar fecha de reserva");
            System.out.println("2) Hacer reserva ");
            System.out.println("3) Salir");
            opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    //System.out.println("Introducir la fecha de inicio en el siguiente formato (dd-mm-yy): \n");
                    inicio = sn.nextLine();
                    //System.out.println("Introducir la fecha de fin en el siguiente formato (dd-mm-yy): \n");
                    fin = sn.nextLine();
                    //System.out.println("Introducir la fecha de cotizacion en el siguiente formato (dd-mm-yy): \n");
                    fechacotizacion = sn.nextLine();
                    //inicio = "26-06-19";
                    //fin = "29-06-19";
                    //fechacotizacion = "26-06-19";
                    double resp = reserva.Cotizar(inicio,fin,fechacotizacion);
                    if(resp == 0){
                        System.out.println("Fechas incorrectas");
                    }else{
                        System.out.println(resp);
                    }
                break;
                case 2:
                    System.out.println("Introducir la fecha de inicio: \n");
                    inicio = sn.nextLine();
                    System.out.println("Introducir la fecha de fin: \n");
                    fin = sn.nextLine();
                    System.out.println("Introducir la fecha id de cliente: \n");
                    idcliente = sn.nextLine();
                    System.out.println("Introducir la fecha de compra: \n");
                    fechacompra = sn.nextLine();
                    System.out.println( reserva.Reservar(inicio,fin,idcliente,fechacompra));
                break;
                case 3:
                    salir=true;
                break;
                default:
                    System.out.println("Opcion invalida \n"); 
                break;
                }
            }

	}
	catch (Exception e){
	    e.printStackTrace();
	}
    }
}
