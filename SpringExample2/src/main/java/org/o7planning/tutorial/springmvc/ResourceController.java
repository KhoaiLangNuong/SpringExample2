package org.o7planning.tutorial.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {
	
	@RequestMapping("/staticResourceTest")
	public String staticResource(Model model){
		return "staticResourceTest";
	}
	
	@RequestMapping("/resourceBundleTest")
	public String resourceBundle(Model model){
		return "resourceBundleTest";
	}
}
