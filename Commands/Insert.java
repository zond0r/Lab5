package Commands;

import Controller.CommandWithObject;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.CreateTicket;
import Utility.ScriptException;

import java.util.InputMismatchException;

public class Insert implements CommandWithObject {
    TicketCollection ticketCollection = new TicketCollection();

    @Override
    public void execute(Object object) {
        try {
            Long id = Long.parseLong((String) object);
            if (ticketCollection.isKeyFree((id))) {
                Ticket ticket = this.getNewTicket(null);
                CreateTicket createTicket = new CreateTicket();
                ticketCollection.putTicket(id, createTicket.create(id));
                System.out.println("Билет успешно добавлен в коллекцию.");
            } else System.out.println("Указанный ключ занят");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Аргумент команды должен быть типа \"long\"");
        } catch (ScriptException e) {
            System.out.println("Неверный параметр для нового объекта: " + e.getWrong());
        }
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public Ticket getNewTicket(Object params) {
        return null;
    }
}
