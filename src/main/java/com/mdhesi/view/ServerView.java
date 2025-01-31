/*
    Handles formatting responses, renders appropriate web pages.

    We have an index.html file that we will parse and render for the client.
    Rendering the HTML will be possible by sending the contents as an HTTP response to the browser.
 */

package com.mdhesi.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServerView {

    public static String fileParser (String filepath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String currentline;
        StringBuilder builder;
        builder = new StringBuilder();

        while((currentline = bufferedReader.readLine()) != null) {
            builder.append(currentline).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

    public static String httpResponse() {
        return null;
    }

}