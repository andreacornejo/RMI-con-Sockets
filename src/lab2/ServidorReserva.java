package lab2;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

/**
 *
 * @author andrea
 */
public class ServidorReserva 
    extends UnicastRemoteObject
    implements InterfaceServidorReserva
    
	 
{
     //Lista Precios de Paquete
    /*public class Paquete {

        private String fecha;
        private int precio;

        public Paquete(String fecha, int precio) {
            this.fecha = fecha;
            this.precio = precio;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }
        
    } */   
    //private List paquete = new LinkedList();
    //List<Paquete> paquetes =new ArrayList<>();
    //Añadimos la lista de paquetes que tenemos
    //paquetes.add(new Paquete("26-06-19",30));
    
    String[] fecha = {"26-06-19","27-06-19","28-06-19","29-06-19","30-06-19"};
    double[] precio = {30,25,25,35,40};
    
    ServidorReserva() throws java.rmi.RemoteException{
	super();
    }
 
    @Override
    public double Cotizar(String inicio, String fin, String fechacotizacion){
        InterfaceCotizador cotizador;
        double costo = 0;
        double dolar;
        try{
            cotizador = (InterfaceCotizador)Naming.lookup("rmi://localhost/Cotizador"); 
            dolar = cotizador.Cotizar(fechacotizacion);
            int f_final = 0;
            int f_inicio = 1;
            for (int i = 0; i < fecha.length; i++) {
                if(fecha[i].equals(fin)){
                    f_final = i;
                }
                if(fecha[i].equals(inicio)){
                    f_inicio = i;
                }
            }
            if(f_inicio <= f_final){
                for( int j = f_inicio ; j <= f_final; j++){
                    costo = costo + precio[j];
                }
                
            }else{
                System.out.println("Fechas incorrectas");
            }
            return costo*dolar;
        }
        catch (Exception e){
	    e.printStackTrace();
	}
        
        return costo;
    }
    

    @Override
    public String Reservar(String inicio, String fin, String idcliente, String fechacompra){
        
        
       return "";
    }
    
    public static void main(String args[]) { 
        
	try {
            
	    ServidorReserva reserva;
	    LocateRegistry.createRegistry(5001);
	    reserva =new ServidorReserva(); 
	    Naming.bind("Reserva", reserva); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    }

   
}
