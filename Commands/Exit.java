package Commands;

import Controller.CommandWithoutArg;

public class Exit implements CommandWithoutArg {
    @Override
    public void execute(Object object){
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }


}
