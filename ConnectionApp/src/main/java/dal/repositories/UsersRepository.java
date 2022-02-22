package dal.repositories;

import dal.parser.Parser;
import model.User;
import java.util.LinkedList;
import java.util.List;

public class UsersRepository<T extends User> implements Repository<T>{

    private List<T> users;
    private static User activeUser;

    public User getActiveUser(User activeUser){
        return activeUser;
    }

    //TODO: specification pattern
    public List<T> read(String name){
        List<T> listToReturn = new LinkedList<T>();
        for(User u : users){
            if(u.getName().compareTo(name)==0){
                listToReturn.add((T)u);
            } else {
                continue;
            }
        }
        return listToReturn;
    }

    public void create(T newUser) throws UniqueNameConflictException{
        String userName = newUser.getName();
        for(User u : users){
            if(u.getName().compareTo(userName) == 0){
                throw new UniqueNameConflictException();
            } else {
                users.add(newUser);
            }
        }
        users.add(newUser);
    }

    public void update(T newUser) {
        User userToUpdate = null;
        for(User u : users){
            if(u.getName().compareTo(activeUser.getName())==0){
                userToUpdate = u;
            }
        }
        userToUpdate.setName(newUser.getName());
        userToUpdate.setEmail(newUser.getEmail());
        userToUpdate.setConnectionIP(newUser.getConnectionIP());
        activeUser = userToUpdate;
    }

    //TODO: check active user remove cases
    public void delete(T newUser) {
        for(User u : users){
            if(u.getName().compareTo(newUser.getName()) == 0){
                users.remove(u);
                return;
            }
        }
    }
}
