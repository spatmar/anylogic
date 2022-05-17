package ru.spatmar.anylogic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.ParseException;

public class TicketsApp {
    public static void main(String[] args) throws JsonProcessingException, ParseException {
        System.out.println("Введите путь к файлу tickets.json");
        String nameJsonFile = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameJsonFile = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TicketWrapper ticketWrapper = null;
        try {
            ticketWrapper = mapper.readValue(new File(nameJsonFile), TicketWrapper.class);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Что-то пошло не так ;(");
        }
        if (ticketWrapper != null) {
            ticketWrapper.averageFlightTimeMin();
            ticketWrapper.percentil();
        } else {
            System.out.println("Определенно не так ;(");
        }



    }
}
