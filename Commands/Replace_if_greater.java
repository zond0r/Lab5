package Commands;

import Controller.CommandWithObject;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.CreateTicket;
import Utility.ScriptException;

import java.io.IOException;
import java.util.HashMap;

public class Replace_if_greater implements CommandWithObject {


    @Override
    public void execute(Object object) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            if (ticketCollection.getSize() == 0) {
                System.out.println("Коллекция как бы пустая.");
            } else {
                long arg = Long.parseLong((String) object);
                HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
                if (tickets.get(arg) != null) {
                    Ticket exmp = new CreateTicket().create(Long.parseLong((String) object));
                    if (exmp.compareTo(tickets.get(arg)) > 0) {
                        tickets.put(arg, exmp);
                        System.out.println("Элемент с id " + object + " успешно заменен.");
                    } else System.out.println("Заданный элемент оказался меньше.");

                } else System.out.println("Нет элемента с таким id.");
            }
        } catch (NumberFormatException |
                NullPointerException e) {
            System.out.println("Ключ указан некорректно,попробуйте ещё раз.");
        } catch (ScriptException e) {
            System.out.println("Неверный параметр для нового объекта: " + e.getWrong());
        }

    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public Ticket getNewTicket(Object params) {
        return null;
    }
}
