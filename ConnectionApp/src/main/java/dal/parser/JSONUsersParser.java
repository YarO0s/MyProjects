package dal.parser;

import dal.repositories.Repository;
import dal.repositories.UsersRepository;
import model.Friend;
import model.User;
import view.FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

public class JSONUsersParser<T extends User> implements Parser<T>{
    private FileInputStream in;
    private FileOutputStream out;
    private FileIO fileIO = new FileIO();

    @Override
    public void write(T instance) {

    }

    public void writeAll(String file, List<User> instancesList){
        try {
            fileIO.write(file, "{");
            fileIO.write(file, "\"users\" : [");
            for(User u : instancesList){
                fileIO.write(file, "\"name\" : \"" + u.getName() + "\",");
                fileIO.write(file, "\"connectionIP\" : \"" + u.getConnectionIP() + "\",");
                fileIO.write(file, "\"email\" : \"" + u.getEmail() + "\",");
                fileIO.write(file, "\"friends\" : [");
                for(Friend f : u.getAllFriends()){
                    fileIO.write(file, "{");
                    fileIO.write(file, "\"name\" : \"" + f.getName() + "\",");
                    fileIO.write(file, "\"connectionIP\" : \"" + f.getConnectionIP() + "\",");
                    fileIO.write(file, "},");
                }
                fileIO.write(file, "]");
                fileIO.write(file, "},");
            }
            fileIO.write(file, "]");
            fileIO.write(file, "}");
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public T read(){
        return null;
    }
}
