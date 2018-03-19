package tads.jpa.demo.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tads.jpa.demo.pojo.Departamento;
import tads.jpa.demo.pojo.Empregado;
 
@Repository
@Transactional
public class DepartamentoDAOImpl extends BaseDAOImpl<Departamento> implements DepartamentoDAO{

	protected DepartamentoDAOImpl() {
		super(Departamento.class);
	}
     
//    @PersistenceContext
//    private EntityManager manager;
// 
//    @Override
//    public List<Departamento> getTodos() {
//        List<Departamento> depts = manager.createQuery("Select a From Departamento a", Departamento.class).getResultList();
//        return depts;
//    }
// 
//    @Override
//    public Departamento getPorId(Integer id) {
//        return manager.find(Departamento.class, id);
//    }
// 
//    @Override
//    public boolean add(Departamento dept) {
//        try{
//            manager.persist(dept);
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
// 
//    @Override
//    public boolean remove(Departamento dept) {
//        try{
//            manager.remove(dept);
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
}