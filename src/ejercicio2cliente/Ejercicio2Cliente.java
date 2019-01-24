package ejercicio2cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Esta aplicación Cliente-Servidor se encarga de sumar una serie de numeros
 * enviados por el cliente y mostrar el total.
 *
 * @author Arturo
 */
public class Ejercicio2Cliente{

    /**
     * El cliente envia una serie de numeros separados por comas y cerrando con
     * una coma final
     *
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr=new InetSocketAddress("localhost", 6666);
            clienteSocket.connect(addr);

            InputStream is=clienteSocket.getInputStream();
            OutputStream os=clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje="6,3,2,8,9,4,5,1,";
            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
