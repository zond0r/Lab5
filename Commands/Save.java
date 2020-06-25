package Commands;

import Controller.CommandWithoutArg;
import Utility.FileRead;
import Utility.SaveInFile;

import java.io.IOException;
import java.util.Scanner;

public class Save implements CommandWithoutArg {
    @Override
    public void execute(Object object) throws IOException {
       try {
           SaveInFile saveInFile = new SaveInFile();
           Scanner in = new Scanner(System.in);
           if (FileRead.getFilename().equals("")) {
               System.out.println("Изначально не было файла с коллекцией. Укажите имя файла сейчас:");
               System.out.print("$ ");
               String filename = in.nextLine();
               saveInFile.Saving(filename);
               System.out.println("Коллекция сохранена в изначальный файл");
           } else {
               saveInFile.Saving(FileRead.getFilename());
               System.out.println("Коллекция сохранена в изначальный файл");
           }
       }
       catch (Exception e){
       }
    }


    @Override
    public String getName() {
        return "save";
    }
}
