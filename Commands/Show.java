package Commands;

import Controller.CommandWithoutArg;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.util.HashMap;
import java.util.Map;

public class Show implements CommandWithoutArg {
    private TicketCollection ticketCollection = new TicketCollection();

    @Override
    public void execute(Object object) {
        HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
        if (tickets.size() > 0) {
            for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                Ticket ticket = entry.getValue();
                System.out.println(ticket.getInfo());
            }
        } else System.out.println("Коллекция пуста.");

    }

    @Override
    public String getName() {
        return "show";
    }

}
