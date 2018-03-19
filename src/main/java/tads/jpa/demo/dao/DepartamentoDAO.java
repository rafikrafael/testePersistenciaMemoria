package tads.jpa.demo.dao;
 
import java.util.List;

import tads.jpa.demo.pojo.Departamento;
 
public interface DepartamentoDAO extends BaseDAO<Departamento>
{
    public List<Departamento> getTodos();
    public Departamento getPorId(Integer id);
    public boolean add(Departamento dept);
    public boolean remove(Departamento dept);
}
