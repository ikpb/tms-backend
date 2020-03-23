package com.tms.service;

import java.util.List;

import com.tms.models.Carrier;

public interface CarrierService {	
	
	//Save the carrier
	void saveCarrier(Carrier carrier);
	
	//Get a single Carrier
	Carrier get(int id);
	
	//Get all Carriers
	List<Carrier> getAllCarriers();
	
	//Update the Carrier
	void update(int id, Carrier carrier);
	
	//Delete a Carrier
	void delete(int id);
	
}
