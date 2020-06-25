
import Commands.*;
import Controller.Commands;
import Ticket.TicketCollection;
import Utility.*;
import Utility.FileRead;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        String filename = "";
        if (args.length != 0) filename = args[0];
        FileRead.setFilename(filename);
        TicketCollection tickets = new TicketCollection();
        tickets.setTickets(Decoder.decodeIntoCollection(FileRead.readFromFile(filename)));
        tickets.setDateOFCreation(java.time.ZonedDateTime.now());
        Commands commands = new Commands();
        commands.regist(new Print_field_descending_type(), new Clear(), new Filter_starts_with_name(), new Show(), new Replace_if_lower(), new Exit(), new Update(), new Remove_lower_key(), new Help(), new Info(),
                new Print_ascending(),new Execute_script(), new Save(), new Insert(), new Remove_key(), new Replace_if_greater());
        while (true) {
            String commandName = FileRead.readFromConsole();
            if (!commandName.equals(""))
                commands.executeCommand(commandName);
        }
    }
}
