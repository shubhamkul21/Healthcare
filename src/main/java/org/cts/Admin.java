package org.cts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Admin {
	@GetMapping("/admin")
	public String viewPatientPage() {
		return "admin";
	}
}
