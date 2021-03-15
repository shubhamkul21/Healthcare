package org.cts;

import java.util.List;

import org.cts.dao.Doctor;
import org.cts.service.DoctorService;
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
public class DoctorController {
	@Autowired 
	private DoctorService doctorService;
	//Doctor
	
		@GetMapping("/doctor")
		public String viewDoctorPage() {
			return "doctor";
		}
		@GetMapping("/newDoctor")
		public String viewAddDoctor(Model model) {
			Doctor doctor=new Doctor();
			model.addAttribute("doctor",doctor);
			return "newDoctor";
		}
		@PostMapping("/saveDoctor")
		public String addDoctor(@ModelAttribute("doctor") Doctor doctor) {
			doctorService.save(doctor);
			return "redirect:/doctor";		
		}
		@GetMapping("/allDoctor")
		public String viewAllDoctor(Model model) {
			List<Doctor> listDoctor=doctorService.listAll();
			model.addAttribute("listDoctor", listDoctor);
			return "allDoctor";
		}
		@RequestMapping("/editDoctor/{id}")
		public ModelAndView viewEditDoctorPage(@PathVariable(name = "id") int id) {
			ModelAndView mav=new ModelAndView("editDoctor");
			Doctor doctor=doctorService.get(id);
			mav.addObject("doctor", doctor);
			return mav;
		}
		@PostMapping("/updateDoctor")
		public String editDoctor(@ModelAttribute("doctor") Doctor doctor) {
			doctorService.save(doctor);
			return "redirect:/allDoctor";		
		}
		@RequestMapping("/deleteDoctor/{id}")
		public String deleteDoctor(@PathVariable(name = "id") int id) {
			doctorService.delete(id);
			return "redirect:/allDoctor";
		}	
}
