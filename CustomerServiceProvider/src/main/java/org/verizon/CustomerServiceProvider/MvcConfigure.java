package org.verizon.CustomerServiceProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfigure implements WebMvcConfigurer  {
	public void addViewControllers(ViewControllerRegistry registry)
	   {
	      registry.addViewController("/index").setViewName("index");
	      registry.addViewController("/login").setViewName("login");
	    
	   }
}
