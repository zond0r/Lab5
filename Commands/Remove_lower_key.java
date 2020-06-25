package Commands;

import Controller.CommandWithObject;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Remove_lower_key implements CommandWithObject {
    @Override
    public void execute(Object o) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            if (ticketCollection.getSize() == 0) {
                System.out.println("Коллекция как бы пустая.");
            } else {
                Iterator it = ticketCollection.getTickets().entrySet().iterator();
                long givenId = Long.parseLong((String) o);
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Ticket ticket = (Ticket) pair.getValue();
                    long currentId = ticket.getId();
                    if (currentId < givenId) {
                        it.remove();
                    }
                }
                System.out.println("Все возможные обьекты были удалены.");
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Неверный аргумент команды.");
        }
    }



    @Override
    public Ticket getNewTicket(Object params) {
        return new Ticket();
    }


    @Override
    public String getName() {
        return "remove_lower_key";
    }
}
