package view;

import model.UserRequest;

import java.util.Scanner;

public class ConsoleIO implements IOManager {
    Scanner scanner = new Scanner(System.in);

    public UserRequest read(){
        return new UserRequest(scanner.nextLine());
    }

    public void write(String message){
        System.out.println(message);
    }

}
