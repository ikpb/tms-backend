package com.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tms.dao.CarrierDAO;
import com.tms.models.Carrier;

@Service
public class CarrierServiceImpl implements CarrierService {
	
	
	private CarrierDAO carrierDao;
	
	@Autowired
	public void setCarrierDao(CarrierDAO carrierDao) {
		this.carrierDao = carrierDao;
	}

	@Override
	public void saveCarrier(Carrier carrier) {
		carrierDao.saveCarrier(carrier);
	}

	@Override
	public Carrier get(int id) {
		return carrierDao.get(id);
	}

	@Override
	public List<Carrier> getAllCarriers() {
		
		return carrierDao.getAllCarriers();
	}

	@Override
	public void update(int id, Carrier carrier) {
		carrierDao.update(id, carrier);

	}

	@Override
	public void delete(int id) {
		carrierDao.delete(id);

	}

}
