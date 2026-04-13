@echo off
if not exist out (
    echo Compilando primero...
    javac -d out src\com\minichat\server\ChatServer.java src\com\minichat\server\ClientHandler.java src\com\minichat\client\ChatClient.java src\com\minichat\client\ChatWindow.java src\com\minichat\common\MessageListener.java
)
java -cp out com.minichat.client.ChatWindow %*
