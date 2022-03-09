package mx.edu.uteq.seguridad_sesiones.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    public void addViewControllers(ViewControllerRegistry registro){
        
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/403").setViewName("/403");
        registro.addViewController("/categorias");
        registro.addViewController("/productos");
        registro.addViewController("/categorias/agregar");
        
    }
    
    
    
}
