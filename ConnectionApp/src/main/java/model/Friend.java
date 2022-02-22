package model;

public class Friend {
    private String name;
    private String connectionIP;

    public Friend(String name, String connectionIP){
        this.name = name;
        this.connectionIP = connectionIP;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getConnectionIP(){
        return connectionIP;
    }

    public void setConnectionIP(String newConnectionIP){
        connectionIP = newConnectionIP;
    }
}
