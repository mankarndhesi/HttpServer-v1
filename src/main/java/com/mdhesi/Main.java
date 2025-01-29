package com.mdhesi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

//        Server socket created on port 8080.
        ServerSocket serverSocket = new ServerSocket(8080);

//        This method looks for connection, this program will stop here until a connection is created.
//        We have to use the socket object to invoke the accept method rather than just using it so we can keep a reference to it later.
//        This convention will also let us use other socket functions.
       Socket socket = serverSocket.accept();


        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
//        We need a getter for the output stream because the socket stream is already created, and we want to access it to send data.
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


        /*
        *
        * END OF PROGRAM
        *
        */

        bufferedWriter.flush();

        socket.close();
        inputStreamReader.close();
        outputStreamWriter.close();
        bufferedReader.close();
        bufferedWriter.close();

    }
}