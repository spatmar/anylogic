package ru.spatmar.anylogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TicketWrapper {

    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    // Среднее время полета в нинутах
    public void averageFlightTimeMin() {
        Long sum = 0L;
        for (Ticket t : tickets) {
            sum += t.flightDuration();
        }
        System.out.printf("Среднее время полета между городами %s и %s %d мин. \n",
                tickets.get(0).getOriginName(), tickets.get(0).getDestinationName(),
                sum / tickets.size());
    }

    //Процентиль по формуле n = (P/100) x N  - (округляется до ближайшего целого числа в бóльшую сторону)
    public void percentil() {
        double percentil = 90.0;
        List<Long> listFlightDuration = tickets.stream()
                .map(Ticket::flightDuration)
                .sorted()
                .collect(Collectors.toList());

        int index = (int) Math.ceil(percentil / 100 * tickets.size()) - 1;

        System.out.printf("%d-й процентиль времени полета: %s мин.",
                (int) percentil, listFlightDuration.get(index));
    }

}
