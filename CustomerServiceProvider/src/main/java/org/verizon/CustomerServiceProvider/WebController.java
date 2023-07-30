package org.verizon.CustomerServiceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages="org.verizon.CustomerServiceProvider")

public class WebController {
	@GetMapping("/")
	public String web() {		
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String adminLogin() {
		return "login";
	}
}
