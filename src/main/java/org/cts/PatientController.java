package org.cts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
	@Autowired 
	private PatientService patientService;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	@GetMapping("/patient")
	public String viewPatientPage() {
		return "patient";
	}
	@GetMapping("/newPatient")
	public String viewAddPatient(Model model) {
		Patient patient=new Patient();
		model.addAttribute("patient",patient);
		return "newPatient";
	}
	@PostMapping("/addPatient")
	public String addPatient(@ModelAttribute("patient") Patient patient,Model model) {
		patientService.save(patient);
		return "redirect:/patient";
		
	}
	@GetMapping("/allPatient")
	public String viewAllPatient(Model model) {
		List<Patient> listPatient=patientService.listAll();
		model.addAttribute("listPatient", listPatient);
		return "allPatient";
	}
	
	
	
	
	
	
	
}
