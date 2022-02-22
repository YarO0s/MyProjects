package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class User {
    private static long counter = 1;
    private final long UID = counter++;
    private String name;
    private String connectionIP;
    private String email;
    private List<Friend> friendsList;

    public User(String name, String connectionIP, String email){
        this.name = name;
        this.connectionIP = connectionIP;
        this.email = email;
        friendsList = new LinkedList<Friend>();
    }

    public void addFriend(Friend... friend){
        Collections.addAll(friendsList, friend);
    }

    public void setName(String newName){
        name = name;
    }

    public String getName(){
        return name;
    }

    public void setConnectionIP(String newConnectionIP){
        connectionIP = newConnectionIP;
    }

    public String getConnectionIP(){
        return connectionIP;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String getEmail(){
        return email;
    }

    public Friend getFriend(String name) throws ItemNotFoundException{
        Friend friendToReturn = null;
        for(Friend f : friendsList){
            if(f.getName().compareTo(name) == 0){
                friendToReturn = f;
            }
        }
        if(friendToReturn == null){
            throw new ItemNotFoundException();
        } else {
            return friendToReturn;
        }
    }
    //TODO: add id's
    public List<Friend> getAllFriends(){
        return friendsList;
    }
}
