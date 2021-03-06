package com.cg.payroll.daoservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
@Component("associateDao")
public class AssociateDaoImpl implements AssociateDAO {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	

	@Override
	public Associate save(Associate associate) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public boolean update(Associate associate) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public Associate findOne(int associateId) {
		
		return entityManagerFactory.createEntityManager().find(Associate.class, associateId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Associate> findAll() {
		Query query=entityManagerFactory.createEntityManager().createNamedQuery("from Associate a",Associate.class);
		return query.getResultList();
	}
	
}
