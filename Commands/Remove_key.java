package Commands;

import Controller.Commandable;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Remove_key implements Commandable {
    @Override
    public void execute(Object par1) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
            Long key = Long.parseLong((String) par1);
            boolean keyExist = false;
            if (tickets.size() > 0) {
                for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                    if (entry.getKey() == key) {
                        keyExist = true;
                    }
                }
            } else System.out.println("Коллекция пуста");
            if (keyExist) {
                ticketCollection.removeTicket(key);
                System.out.println("Элемент с ключом " + key + " удалён из коллекции.");
            } else
                System.out.println("Элемент с заданным ключом не существует");

        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Ключ указан некорректно,попробуйте ещё раз.");
        }
    }

    @Override
    public String getName() {
        return "remove_key";
    }
}

