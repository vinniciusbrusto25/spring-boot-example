/*This class will store our actions.*/

package br.com.example.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*"Controller" annotation represents the 
 * spring integration.*/

@Controller
public class HelloController {
	
	/**
	 * This is an action called "hello" that handle a requisition. 
	 * 
	 * @return The name of the view tied to the controller.
	 * In this case, will be a HTML page called hello.html
	 * stored in the "templates" folder.
	 */
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "Vinicius");
		return "hello";
	}

}
