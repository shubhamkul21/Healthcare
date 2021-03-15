package org.cts;

import java.util.List;

import org.cts.dao.Doctor;
import org.cts.dao.Practitioner;
import org.cts.service.DoctorService;
import org.cts.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PractitionerController {
	@Autowired 
	private PractitionerService practitionerService;
	
	@GetMapping("/practitioner")
	public String viewDoctorPage() {
		return "practitioner";
	}
	@GetMapping("/newPractitioner")
	public String viewAddPractitioner(Model model) {
		Practitioner practitioner=new Practitioner();
		model.addAttribute("practitioner",practitioner);
		return "newPractitioner";
	}
	@PostMapping("/savePractitioner")
	public String addPractitioner(@ModelAttribute("practitioner") Practitioner practitioner) {
		practitionerService.save(practitioner);
		return "redirect:/practitioner";		
	}
	@GetMapping("/allPractitioner")
	public String viewAllPractitioner(Model model) {
		List<Practitioner> listPractitioner=practitionerService.listAll();
		model.addAttribute("listPractitioner", listPractitioner);
		return "allPractitioner";
	}
	@RequestMapping("/editPractitioner/{id}")
	public ModelAndView viewEditPractitionerPage(@PathVariable(name = "id") int id) {
		ModelAndView mav=new ModelAndView("editPractitioner");
		Practitioner practitioner=practitionerService.get(id);
		mav.addObject("practitioner", practitioner);
		return mav;
	}
	@PostMapping("/updatePractitioner")
	public String editPractitioner(@ModelAttribute("practitioner") Practitioner practitioner) {
		practitionerService.save(practitioner);
		return "redirect:/allPractitioner";		
	}
	@RequestMapping("/deletePractitioner/{id}")
	public String deletePractitioner(@PathVariable(name = "id") int id) {
		practitionerService.delete(id);
		return "redirect:/allPractitioner";
	}	
}
