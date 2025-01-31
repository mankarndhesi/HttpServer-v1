/*
    Manages data, such as request & response handling.
 */

package com.mdhesi.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

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

    public void destroyConnections() throws Exception {

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