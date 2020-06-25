package Commands;

import Controller.CommandWithoutArg;
import Ticket.TicketCollection;

public class Clear implements CommandWithoutArg {
    TicketCollection ticketCollection = new TicketCollection();
    @Override
    public void execute(Object object) {
        if (ticketCollection.getTickets().size()>0){
            ticketCollection.getTickets().clear();
            System.out.println("Коллекция очищена.");
            ticketCollection.setDateOFCreation(null);
        }
        else System.out.println("Коллекция уже пуста.");
    }

    @Override
    public String getName() {
        return "clear";
    }


}
