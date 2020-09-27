package service;
import java.util.List;

public interface IManager<T> {
    void add(T object);
    void update(long id, T newObject);
    void delete(long id);
    List<T> showAll( );
    List<T> findProByName(String name );
    T findById(long id);
}
