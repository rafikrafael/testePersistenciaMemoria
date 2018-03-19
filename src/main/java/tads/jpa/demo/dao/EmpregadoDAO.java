package tads.jpa.demo.dao;
 
import java.util.List;

import tads.jpa.demo.pojo.Empregado;
 
public interface EmpregadoDAO
{
    public List<Empregado> getTodosEmpregados();
    public List<Empregado> getTodosEmpregadosPorDepartamento(Integer id);
    public Empregado getEmpregadoPorId(Integer id);
    public boolean addEmpregado(Empregado empregado);
    public boolean removeEmpregado(Empregado empregado);
}