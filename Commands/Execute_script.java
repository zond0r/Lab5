package Commands;

import Controller.CommandWithObject;
import Controller.Commandable;
import Controller.Commands;
import Utility.CreateTicket;
import Utility.FileRead;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Execute_script implements Commandable {
    Commands invoker = new Commands();
    HashMap scripts = new HashMap();

    @Override
    public void execute(Object arg) {
        scripts.put((String) arg, 1);
        try {
            String data = FileRead.readFromFile((String) arg);
            Commands command = new Commands();
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    boolean isValidScript = true;
                    if (!(commands[i].equals(""))) {
                        String[] commandAndArg = commands[i].split(" ");
                        if (commandAndArg[0].equals("execute_script")) {
                            if (scripts.get(commandAndArg[1]) == null)
                                scripts.put(commandAndArg[1], 1);
                            else isValidScript = false;
                        }
                        try {
                            CommandWithObject commandWithObject = (CommandWithObject) Commands.getCommand(commandAndArg[0]);
                            if (commandWithObject != null) {
                                String[] params = new String[8];
                                try {
                                    for (int j = 0; j < 8; j++) {
                                        i++;
                                        params[j] = (commands[i]);
                                    }
                                    CreateTicket.isInScript = true;
                                    CreateTicket.setParams(params);
                                    System.out.println("\nКоманда \"" + commands[i - 8] + "\":");
                                    command.executeCommand(commands[i - 8]);
                                    CreateTicket.isInScript = false;
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Команда \"" + commandAndArg[0] + "\":");
                                    System.out.println("Недостаточно параметров");
                                }
                            }
                        } catch (Exception e) {
                            if (isValidScript) {
                                System.out.println("Команда \"" + commands[i] + "\":");
                                command.executeCommand(commands[i]);
                                System.out.println();
                            } else {
                                System.out.println("Команда \"" + commands[i] + "\": невыполнима.\n");
                            }
                        }
                    }
                }
            } else System.out.println("Указанный файл не найден.");
        } catch (NullPointerException | FileNotFoundException e) {
        } finally {
            scripts.clear();
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
