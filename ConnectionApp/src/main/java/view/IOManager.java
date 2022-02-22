package view;

import model.UserRequest;

public interface IOManager {
    public void write(String message);
    public UserRequest read();
}
