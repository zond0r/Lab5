package Controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();
    private static ArrayList<String> history = new ArrayList<>();

    public static Commandable getCommand(String commandname){
        return commands.get(commandname);
    }
    public void regist(Commandable... commands) {
        for (Commandable command : commands)
            Commands.commands.put(command.getName(), command);
    }

    public void executeCommand(String commandName) {
        String[] nameAndArgument = commandName.split(" ");
        commandName = commandName.replace(" ", "");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        commands.get(nameAndArgument[0]).execute(null);
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commands.get(nameAndArgument[0]).execute(nameAndArgument[1]);
                        } catch (IndexOutOfBoundsException | FileNotFoundException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}