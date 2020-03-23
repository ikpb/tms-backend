package com.tms.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tms.models.Carrier;

@Component
public class CarrierDaoImpl implements CarrierDAO {
	

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSf(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveCarrier(Carrier carrier) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(carrier);
		tx.commit();
	}

	@Override
	public Carrier get(int id) {
		Session sess = sessionFactory.openSession();
		return sess.get(Carrier.class, id);
	}

	@Override
	public List<Carrier> getAllCarriers() {
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Carrier> cq = cb.createQuery(Carrier.class);
		Root<Carrier> rootEntry = cq.from(Carrier.class);
		CriteriaQuery<Carrier> all = cq.select(rootEntry);
		
		TypedQuery<Carrier> allQuery = sess.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public void update(int id, Carrier carrier) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Carrier oldCarrier = sess.byId(Carrier.class).load(id);
		oldCarrier.setCarrierName(carrier.getCarrierName());
		oldCarrier.setAddress(carrier.getAddress());
		oldCarrier.setCity(carrier.getCity());
		oldCarrier.setState(carrier.getState());
		oldCarrier.setZipcode(carrier.getZipcode());
		oldCarrier.setPocFirstName(carrier.getPocFirstName());
		oldCarrier.setPocLastName(carrier.getPocLastName());
		oldCarrier.setPhoneNumber(carrier.getPhoneNumber());
		oldCarrier.setFaxNumber(carrier.getFaxNumber());
		oldCarrier.setNumberOfTrucks(carrier.getNumberOfTrucks());
		oldCarrier.setClassification(carrier.getClassification());
		sess.flush();
		tx.commit();
	}

	@Override
	public void delete(int id) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		Carrier carrier = sess.byId(Carrier.class).load(id);
		sess.delete(carrier);
		tx.commit();

	}

}
