package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Ticket.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Print_field_descending_type implements CommandWithoutArg {
    @Override
    public void execute(Object o) throws FileNotFoundException, IOException {
            TicketCollection ticketCollection = new TicketCollection();
            HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
            ArrayList<TicketType> types = new ArrayList<>();
            if (tickets.size() > 0) {
                for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                    Ticket ticket = entry.getValue();
                    types.add(ticket.getType());
                }
                Collections.sort(types);
                System.out.println("Поля type всех элементов в порядке убывания:");
                for (int i = types.size()-1; i >= 0; i--) {
                    System.out.println(types.get(i));

                }
            } else System.out.println("Коллекция пуста.");
    }
    @Override
    public String getName() {
        return "print_field_descending_type";
    }
}
