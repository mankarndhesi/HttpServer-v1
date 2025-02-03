/*
    Handles request parsing and generates responses.
    Decides whether to close the connection.
 */

package com.mdhesi.controller;

import com.mdhesi.model.ServerModel;
import com.mdhesi.view.ServerView;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerController {

    private static final String filepath = "src/main/java/com/mdhesi/view/index.html";
    ServerView viewer = new ServerView();

    public static String fileParser () throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(ServerController.getFilepath()));
        String currentline;
        StringBuilder builder;
        builder = new StringBuilder();

        while((currentline = bufferedReader.readLine()) != null) {
            builder.append(currentline).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

    public static String httpResponse() throws IOException {

        final String CRLF = "\r\n";

        return "HTTP/1.1 200 OK" + CRLF + "Content-Length: " + ServerController.fileParser().getBytes().length +CRLF +
        CRLF + ServerController.fileParser() + CRLF + CRLF;
    }

    public static void sendResponse(Socket clientSocket) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        String response = httpResponse();
        outputStream.write(response.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }



    public static String getFilepath() {
        return filepath;
    }
}