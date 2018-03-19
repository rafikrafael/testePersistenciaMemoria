package tads.jpa.demo.dao;

import java.util.List;

public interface BaseDAO<T> {

	public List<T> getTodos();    
    public T getPorId(Integer id);
    public boolean add(T objeto);
    public boolean remove(T objeto);
}
