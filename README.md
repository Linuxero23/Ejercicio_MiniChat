# MiniChat TCP Java

Proyecto de chat en Java usando sockets TCP y Swing.

## Estructura del proyecto

- `src/com/minichat/server/ChatServer.java` - Servidor TCP que acepta conexiones de cliente y reenvía mensajes.
- `src/com/minichat/server/ClientHandler.java` - Hilo por cliente que lee mensajes y cierra recursos correctamente.
- `src/com/minichat/client/ChatClient.java` - Lógica de cliente, maneja conexión y notifica observadores.
- `src/com/minichat/client/ChatWindow.java` - Interfaz Swing para enviar y recibir mensajes.
- `src/com/minichat/common/MessageListener.java` - Interfaz Observer para notificaciones de mensajes.

## Cómo ejecutar

1. Abre una terminal dentro de la carpeta `minichat6`.
2. Compila todo:

```bat
javac -d out src\com\minichat\server\ChatServer.java src\com\minichat\server\ClientHandler.java src\com\minichat\client\ChatClient.java src\com\minichat\client\ChatWindow.java src\com\minichat\common\MessageListener.java
```

3. Inicia el servidor:

```bat
java -cp out com.minichat.server.ChatServer
```

4. Inicia uno o varios clientes:

```bat
java -cp out com.minichat.client.ChatWindow
```

## Notas

- El servidor usa un hilo por cliente para permitir conexiones concurrentes.
- La UI se actualiza usando el patrón Observer con `MessageListener`.
- El código maneja cierre de sockets y flujos con `try/catch`.
