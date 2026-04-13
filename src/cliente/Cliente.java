package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Cliente simple que se conecta a 127.0.0.1:5000 y envía mensajes con DataOutputStream.
 */
public class Cliente {
    private Socket socket;
    private DataOutputStream salida;

    public void conectar() throws IOException {
        socket = new Socket("127.0.0.1", 5000);
        salida = new DataOutputStream(socket.getOutputStream());
    }

    public void enviarMensaje(String mensaje) {
        try {
            if (salida != null) {
                salida.writeUTF(mensaje);
                salida.flush();
            }
        } catch (IOException e) {
            System.out.println("Error al enviar mensaje: " + e.getMessage());
        }
    }

    public void cerrar() {
        try {
            if (salida != null) {
                salida.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error al cerrar cliente: " + e.getMessage());
        }
    }
}
