package com.dao;

import com.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PartsDaoImpl implements PartsDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void addPart(Part part) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(part);
	}
	
	@Override
	@Transactional
	public void updatePart(Part part) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(part);
	}
	
	@Override
	@Transactional
	public void removePart(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Part part = session.load(Part.class, new Integer(id));
		if(part !=null){
			session.delete(part);
		}
	}
	
	@Override
	@Transactional
	public Part getPartById(int id) {
		Session session =this.sessionFactory.getCurrentSession();
		Part part = session.get(Part.class, new Integer(id));
		return part;
	}
	
	@Override
	@Transactional
	public List<Part> listParts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Part> partsList = session.createQuery("from Part").list();
		return partsList;
	}
}