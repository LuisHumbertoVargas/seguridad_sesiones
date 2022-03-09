package mx.edu.uteq.seguridad_sesiones.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    Creación de los usuarios
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123") //noop indica que no encripte el password
                .roles("ADMIN", "USER") //automáticamente spring agrega ROLE_
                .and()
                .withUser("user")
                .password("{noop}123") //noop indica que no encripte el password
                .roles("USER"); //automáticamente spring agrega ROLE_
    }
    
//    Sin esto cualquier usuario puede vistar cualquier vista (permisos)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/categorias/agregar")
                .hasRole("ADMIN")
                .antMatchers("/","/categorias","/productos")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

    
    
}
