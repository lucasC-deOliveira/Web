package  br.edu.uniceplac.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public abstract class AbstractSession <T extends AbstractEntity, K> {
	
	  protected Class<T> type; 

	    @PersistenceContext
	    protected EntityManager entityManager;
	    
	    

	    public AbstractSession() {
	        super();
	    }

	    public AbstractSession(Class<T> type) {
	        this.type = type;
	    }

	    private void persist(T entity) {
	        try {
	            entityManager.persist(entity);
	        } catch (PersistenceException ex) {
	        	ex.printStackTrace();
	            throw new RuntimeException(ex);
	        }
	    }

	    public void save(final T entity) {
	        if (entity.getId() == null) {
	            persist(entity);
	        } else {
	            update(entity);
	        }
	    }

	    public void update(T entity) {
	        try {
	            entityManager.merge(entity);
	        } catch (PersistenceException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

	    public void delete(final K id) {
	        try {
	            T obj = entityManager.getReference(type, id);
	            entityManager.remove(obj);
	        } catch (final PersistenceException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

	    public T find(final K id) {
	        return entityManager.find(type, id);
	    }

	    public List<T> findAll() {
	        TypedQuery<T> query = entityManager.createQuery("select a from " + type.getName() + " a", type);
	        return query.getResultList();
	    }

}
