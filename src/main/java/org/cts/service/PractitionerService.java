package org.cts.service;

import java.util.List;

import org.cts.dao.Practitioner;
import org.cts.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PractitionerService {
	@Autowired
	private PractitionerRepository practitionerRepository;
	
	public List<Practitioner> listAll(){
		return practitionerRepository.findAll();		
	}
	
	public void save(Practitioner practitioner) {
		practitionerRepository.save(practitioner);
	}
	
	public Practitioner get(long id) {
		return practitionerRepository.findById(id).get();
	}
	
	public void delete(long id) {
		practitionerRepository.deleteById(id);
	}


}
