package service;
import java.util.List;

public interface IManager<T> {
    void add(T object);
    void update(Long id, T newobject);
    void delete(Long id);
    List<T> showAll( );
    List<T> findProByName(String name );
}
