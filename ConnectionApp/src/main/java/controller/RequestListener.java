package controller;

import controller.command.*;
import model.UserRequest;
import view.*;

import java.io.IOException;

public class RequestListener {
    IOManager consoleIO = new ConsoleIO();

    public void listen(){
        Command command = null;
        do{
            UserRequest request = consoleIO.read();
            command = mapRequest(request);
            if(command == null){
                continue;
            }
            command.execute();
        } while(!(command instanceof ExitCommand));

    }

    public Command mapRequest(UserRequest request){
        String instruction = request.getInstruction();

        switch(instruction){
            case "exit":
                return new ExitCommand();
            case "newuser":
                return new UserCreationCommand(request);
            case "users":

            default:
                consoleIO.write("Command '" + instruction + "' has not been found");
                return null;
        }
    }
}
