/*
    Driver class -- Used for starting server.
 */

package com.mdhesi;

import com.mdhesi.model.ServerModel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server starting...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        ServerModel serverModel = new ServerModel();
        serverModel.initializeConnections(serverSocket, socket);


    }
}