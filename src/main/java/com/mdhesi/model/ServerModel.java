/*
    Manages the server socket and accepts connections.
    Passes the connection to the controller.
 */

package com.mdhesi.model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("ALL")
public class ServerModel {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private InputStreamReader inputStreamReader = null;
    private OutputStreamWriter outputStreamWriter = null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

    public void initializeConnections(ServerSocket serverSocket, Socket socket) throws Exception {
        this.serverSocket = serverSocket;
        this.socket = socket;
        this.inputStreamReader = new InputStreamReader(socket.getInputStream());
        this.outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        this.bufferedReader = new BufferedReader(inputStreamReader);
        this.bufferedWriter = new BufferedWriter(outputStreamWriter);
    }

    public void closeConnections() throws Exception {
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (inputStreamReader != null) inputStreamReader.close();
            if (outputStreamWriter != null) outputStreamWriter.close();
            if (socket != null) socket.close();
            if (serverSocket != null) serverSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public InputStreamReader getInputStreamReader() {
        return inputStreamReader;
    }

    public OutputStreamWriter getOutputStreamWriter() {
        return outputStreamWriter;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }
}