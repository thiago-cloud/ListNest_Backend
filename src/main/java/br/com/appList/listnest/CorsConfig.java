package br.com.appList.listnest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	 
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Permite todos os endpoints
	                .allowedOrigins("http://localhost:4200") // Permite o front-end
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
	                .allowedHeaders("*") // Permite todos os cabeçalhos
	                .allowCredentials(true); // Permite envio de cookies ou autenticação
	    }
}
