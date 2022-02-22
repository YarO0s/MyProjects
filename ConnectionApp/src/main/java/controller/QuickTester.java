package controller;

import dal.parser.JSONUsersParser;
import dal.parser.Parser;
import model.Friend;
import model.User;
import view.FileIO;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class QuickTester {
    public static void main(String[] args){
        List<User> usersList = new LinkedList<User>();
        usersList.add(new User("Ben Gann", "126:0:13:134", "gann@gmail.com"));
        User u = new User("Kyle Broflowski","243:150:39:129","kyle@gmail.com");
        u.addFriend(new Friend("Joe","200:10:200:10"), new Friend("Ben","234:19:125:240"));
        usersList.add(u);
        JSONUsersParser<User> parser = new JSONUsersParser<User>();
        parser.writeAll("D:/ConnectionApp/src/main/resources/UserData/UserList.json", usersList);
    }
}
