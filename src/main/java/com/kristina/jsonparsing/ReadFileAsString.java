package com.kristina.jsonparsing;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileAsString {
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        String data = readFileAsString("example-response-from-weatherbit.io.json");
        System.out.println(data);
    }
}
