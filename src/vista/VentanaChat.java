package vista;

import cliente.Cliente;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * VentanaChat crea una ventana simple que permite escribir mensajes y enviarlos al servidor.
 */
public class VentanaChat {
    private Cliente cliente;
    private JTextArea areaMensajes;
    private JTextField campoTexto;

    public VentanaChat() {
        crearInterfaz();
        conectarCliente();
    }

    private void crearInterfaz() {
        JFrame ventana = new JFrame("Mini Chat TCP");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(new Dimension(400, 300));
        ventana.setLayout(new BorderLayout());

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        ventana.add(new JScrollPane(areaMensajes), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        campoTexto = new JTextField();
        JButton botonEnviar = new JButton("Enviar");
        panelInferior.add(campoTexto, BorderLayout.CENTER);
        panelInferior.add(botonEnviar, BorderLayout.EAST);

        ventana.add(panelInferior, BorderLayout.SOUTH);

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        campoTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void conectarCliente() {
        cliente = new Cliente();
        try {
            cliente.conectar();
            areaMensajes.append("Conectado al servidor 127.0.0.1:5000\n");
        } catch (IOException e) {
            areaMensajes.append("No se pudo conectar al servidor: " + e.getMessage() + "\n");
        }
    }

    private void enviarMensaje() {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            return;
        }

        areaMensajes.append("Yo: " + texto + "\n");
        cliente.enviarMensaje(texto);
        campoTexto.setText("");
    }

    public static void main(String[] args) {
        new VentanaChat();
    }
}
