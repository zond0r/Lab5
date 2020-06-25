package Commands;

import Controller.Commandable;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.IOException;
import java.util.Map;

public class Filter_starts_with_name implements Commandable {
    @Override
    public void execute(Object o) throws IOException {
        String subSt = (String) o;
        boolean was = false;
        TicketCollection collection = new TicketCollection();
        if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
        else for (Map.Entry<Long, Ticket> entry: collection.getTickets().entrySet()) {
            if (entry.getValue().getName().indexOf(subSt) == 0) {
                was = true;
                System.out.println(entry.getValue().getInfo());
            }
        }
        if (!was) System.out.println("Нет таких элементов в коллекции");
    }


    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
