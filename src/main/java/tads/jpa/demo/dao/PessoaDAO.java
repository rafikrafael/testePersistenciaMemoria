package tads.jpa.demo.dao;

import java.util.List;

import tads.jpa.demo.pojo.Pessoa;

public interface PessoaDAO extends BaseDAO<Pessoa>
{
    public List<Pessoa> getTodos();
    public Pessoa getPorId(Integer id);
    public boolean add(Pessoa dept);
    public boolean remove(Pessoa dept);
}
