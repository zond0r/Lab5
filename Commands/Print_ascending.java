package Commands;

import Controller.CommandWithoutArg;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Print_ascending implements CommandWithoutArg {
    @Override
    public void execute(Object o) throws FileNotFoundException, IOException {

        TicketCollection ticketCollection = new TicketCollection();
        if (ticketCollection.getSize() != 0) {
            HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
            List<Long> keys = new ArrayList(tickets.keySet());
            Collections.sort(keys);
            for (Long key : keys)
                System.out.println(ticketCollection.getTicket(key).getInfo());

        } else System.out.println("Коллекция пуста.");
    }

    @Override
    public String getName() {
        return "print_ascending";
    }
}
