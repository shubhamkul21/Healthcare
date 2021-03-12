package org.cts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> listAll(){
		return patientRepository.findAll();		
	}
	
	public void save(Patient patient) {
		patientRepository.save(patient);
	}
	
	public Patient get(long id) {
		return patientRepository.findById(id).get();
	}
	
	public void delete(long id) {
		patientRepository.deleteById(id);
	}

}
