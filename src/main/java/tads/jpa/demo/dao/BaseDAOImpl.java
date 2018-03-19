package tads.jpa.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

	@PersistenceContext
	protected EntityManager manager;

	private Class<T> persistedClass;

	protected BaseDAOImpl() {
		
	}
	
	protected BaseDAOImpl(Class<T> persistedClass) {
       this.persistedClass = persistedClass;
    }

	@Override
	public List<T> getTodos() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return manager.createQuery(query).getResultList();
	}

	@Override
	public T getPorId(Integer id) {
		return manager.find(persistedClass, id);
	}

	@Override
	public boolean add(T objeto) {
		try {
			manager.persist(objeto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(T objeto) {
		// CriteriaBuilder builder = manager.getCriteriaBuilder();
		// CriteriaQuery<T> query = builder.createQuery(persistedClass);
		// query.from(persistedClass);
		// query.equals(objeto);
		// T entity = manager.createQuery(query).getSingleResult();
		// T mergedEntity = manager.merge(entity);
		try {
			manager.remove(objeto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
