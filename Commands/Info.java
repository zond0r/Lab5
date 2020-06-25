package Commands;


import Controller.CommandWithoutArg;
import Ticket.TicketCollection;

public class Info implements CommandWithoutArg {

    @Override
    public void execute(Object object){
        TicketCollection ticketCollection = new TicketCollection();
        System.out.println(ticketCollection.getInfo());
    }


    @Override
    public String getName() {
        return "info";
    }
}
