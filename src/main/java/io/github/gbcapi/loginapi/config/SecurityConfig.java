package io.github.gbcapi.loginapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration: diz ao Spring que esta classe define Beans (objetos gerenciados por ele)
@Configuration
public class SecurityConfig {

    // @Bean: registra este metodo como uma "fabrica" de um objeto gerenciado pelo Spring.
    // Qualquer classe que precisar de um PasswordEncoder podera "pedir" esse objeto
    // ao Spring, em vez de criar uma nova instancia manualmente.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/usuarios").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}