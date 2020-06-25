package Controller;


import Ticket.Ticket;

public interface CommandWithObject extends Commandable{
    public Ticket getNewTicket(Object params);
}
