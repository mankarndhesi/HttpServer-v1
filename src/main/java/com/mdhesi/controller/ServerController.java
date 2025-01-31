/*
    Controller class -- Directs traffic, processes, and sends responses.
 */

package com.mdhesi.controller;

import com.mdhesi.model.ServerModel;
import com.mdhesi.view.ServerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {

    private static final String filepath = "src/main/java/com/mdhesi/view/index.html";
    ServerView viewer = new ServerView();

    public static String fileParser () throws IOException {

        ServerController controller = new ServerController();

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

        final String CRLF = "\n\r";
        String response =

                "HTTP/1.1 200 OK" + CRLF + "Content-Length: " + ServerController.fileParser().getBytes().length +CRLF +
                CRLF + ServerController.fileParser() + CRLF + CRLF;




        return response;
    }

    public static String getFilepath() {
        return filepath;
    }
}