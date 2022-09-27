package spring.ejemplo.web;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	// Indicar el idioma - I interface
	@Bean
	public LocaleResolver localeResolver() {
		
		//SessionLocaleResolver()
		var slr = new SessionLocaleResolver();
		
		// especificamos el idioma, el lenguaje por default
		slr.setDefaultLocale(new Locale("es"));
		
		return slr;
	}
	
	// Interceptor - II interface
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	// Registro interceptor - III interface
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		
		registro.addInterceptor(localeChangeInterceptor());
	}
	
	// Vista página web controladores
	@Override
	public void addViewControllers(ViewControllerRegistry registro) {
		// agregamos path por default y un nombre
		registro.addViewController("/").setViewName("index");
		registro.addViewController("/login");
		registro.addViewController("/errores/403").setViewName("/errores/403");
	}
	
}
