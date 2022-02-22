package dal.repositories;

import java.util.List;

public interface Repository<T> {

    List<T> read(String name);

    void create(T unit) throws UniqueNameConflictException;

    void update (T unit);

    void delete (T unit);
}
