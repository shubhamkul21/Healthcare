package org.cts.service;

import java.util.List;

import org.cts.dao.Doctor;
import org.cts.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> listAll(){
		return doctorRepository.findAll();		
	}
	
	public void save(Doctor doctor) {
		doctorRepository.save(doctor);
	}
	
	public Doctor get(long id) {
		return doctorRepository.findById(id).get();
	}
	
	public void delete(long id) {
		doctorRepository.deleteById(id);
	}


}
