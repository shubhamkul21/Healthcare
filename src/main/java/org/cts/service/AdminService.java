package org.cts.service;

import java.util.List;

import org.cts.dao.Admin;
import org.cts.dao.Doctor;
import org.cts.repository.AdminRepository;
import org.cts.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> listAll(){
		return adminRepository.findAll();		
	}
	
	public void save(Admin admin) {
		adminRepository.save(admin);
	}
	
	public Admin get(long id) {
		return adminRepository.findById(id).get();
	}

}
