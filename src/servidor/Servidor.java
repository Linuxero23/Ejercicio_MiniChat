package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor simple que usa ServerSocket para escuchar conexiones.
 * Recibe mensajes desde un cliente y los imprime en la consola.
 */
public class Servidor {
    public static void main(String[] args) {
        final int puerto = 5000;
        System.out.println("Servidor iniciado. Esperando cliente en puerto " + puerto + "...");

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress());

            try (DataInputStream entrada = new DataInputStream(cliente.getInputStream())) {
                while (true) {
                    String mensaje = entrada.readUTF();
                    System.out.println("Mensaje recibido: " + mensaje);
                }
            } catch (IOException errorLectura) {
                System.out.println("Conexion finalizada o error de lectura: " + errorLectura.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }

        System.out.println("Servidor detenido.");
    }
}
