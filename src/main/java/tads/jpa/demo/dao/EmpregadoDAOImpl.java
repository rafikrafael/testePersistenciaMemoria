package tads.jpa.demo.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tads.jpa.demo.pojo.Empregado;
 
@Repository
@Transactional
public class EmpregadoDAOImpl implements EmpregadoDAO {
     
    @PersistenceContext
    private EntityManager manager;
 
    @Override
    public List<Empregado> getTodosEmpregados() {
        List<Empregado> empregados = manager.createQuery("Select a From Empregado a join fetch a.enderecos", Empregado.class).getResultList();
        return empregados;
    }
 
    @Override
    public List<Empregado> getTodosEmpregadosPorDepartamento(Integer idDepartamento) {
    		Query query = manager.createQuery("Select a from Empregado a where a.departamento.id = :idDepartamento", Empregado.class);
    		query.setParameter("idDepartamento", idDepartamento);
    		List<Empregado> empregados = query.getResultList();         
        return empregados;
    }
 
    @Override
    public Empregado getEmpregadoPorId(Integer id) {
        return manager.find(Empregado.class, id);
    }
 
    @Override
    public boolean addEmpregado(Empregado empregado) {
        try{
            manager.persist(empregado);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    @Override
    public boolean removeEmpregado(Empregado empregado) {
        try{
            manager.remove(empregado);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}