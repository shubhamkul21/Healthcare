package org.cts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@PostMapping("/savePatient")
	public String addPatient(@ModelAttribute("patient") Patient patient) {
		patientService.save(patient);
		return "redirect:/patient";		
	}
	@GetMapping("/allPatient")
	public String viewAllPatient(Model model) {
		List<Patient> listPatient=patientService.listAll();
		model.addAttribute("listPatient", listPatient);
		return "allPatient";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditPatientPage(@PathVariable(name = "id") int id) {
		ModelAndView mav=new ModelAndView("editPatient");
		Patient patient=patientService.get(id);
		mav.addObject("patient", patient);
		return mav;
	}
	@PostMapping("/editPatient")
	public String editPatient(@ModelAttribute("patient") Patient patient) {
		patientService.save(patient);
		return "redirect:/allPatient";		
	}
	@RequestMapping("/delete/{id}")
	public String deletePatient(@PathVariable(name = "id") int id) {
		patientService.delete(id);
		return "redirect:/allPatient";
	}
	
	
	
	
	
	
}
