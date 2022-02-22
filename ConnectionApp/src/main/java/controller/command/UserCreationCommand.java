package controller.command;

import model.UserRequest;

public class UserCreationCommand implements Command{
    private UserRequest userRequest;

    public UserCreationCommand(UserRequest newUserRequest){
        userRequest = newUserRequest;
    }

    public void execute(){

    }
}
