package dal.parser;

import dal.repositories.Repository;
import model.User;

public interface Parser<T> {
    void write(T instance);
    T read();
}
