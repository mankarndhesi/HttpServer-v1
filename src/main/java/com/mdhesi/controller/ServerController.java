/*
    Controller class -- Directs traffic, processes, and sends responses.
 */

package com.mdhesi.controller;

import com.mdhesi.model.ServerModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {

    public static String fileParser () throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("index.html"));
        String html = null;
        StringBuilder builder = new StringBuilder();

        while((html = bufferedReader.readLine()) != null) {
            builder.append()
        }


        bufferedReader.close();
        return html;
    }

}