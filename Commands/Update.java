package Commands;

import Controller.CommandWithObject;
import Ticket.*;
import Utility.CreateTicket;
import Utility.ScriptException;

import java.util.HashMap;
import java.util.Map;

public class Update implements CommandWithObject {

    @Override
    public void execute(Object key) {
        boolean keyExist = false;
        try {
            TicketCollection ticketCollection = new TicketCollection();
            HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
            long keyn = Long.parseLong((String) key);
            if (tickets.size() > 0) {
                for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                    if (entry.getKey() == (keyn)) {
                        keyExist = true;
                        break;
                    }
                }
            } else System.out.println("Коллекция пуста");
            CreateTicket createTicket = new CreateTicket();
            if (keyExist) {
                ticketCollection.replaceMovie(Long.parseLong((String) key), createTicket.create(Long.parseLong((String) key)));
                System.out.println("Элемент с ключом " + key + " обновлён.");
            } else {
                System.out.println("Элемент с заданным ключом не существует,попробуйте ввести команду снова.");
            }
        }
        catch (NumberFormatException |
                NullPointerException e){
            System.out.println("Неверный аргумент команды.");
        }
        catch (ScriptException e){
            System.out.println("Неверный параметр для нового объекта: " + e.getWrong());
        }
    }
    @Override
    public String getName(){
        return "update";
    }


    @Override
    public Ticket getNewTicket(Object params) {
        return null;
    }
}
