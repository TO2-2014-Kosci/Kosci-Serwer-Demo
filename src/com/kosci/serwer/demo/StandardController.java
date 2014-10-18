package com.kosci.serwer.demo;


import javax.json.Json;
import javax.json.JsonReader;
import java.io.StringReader;

public class StandardController implements IController {
    @Override
    public String respondTo(String message) {
        JsonReader reader = Json.createReader(new StringReader(message));
        return new StringBuilder(reader.readObject().getString("message")).reverse().toString();
    }
}
