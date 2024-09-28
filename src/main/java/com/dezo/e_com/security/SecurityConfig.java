package com.dezo.e_com.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dezo.e_com.repository.UserRepository;
import com.dezo.e_com.service.UserService;

@Configuration
public class SecurityConfig {

  @Autowired
  private UserRepository userRepository;

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(crsf -> crsf.disable())
        .cors(Customizer.withDefaults())
        .authorizeHttpRequests(
            auth -> auth
                .requestMatchers("/auth").permitAll()
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults())
        .headers().frameOptions().sameOrigin();

    return http.build();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:3000"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    configuration.setAllowCredentials(true);
    configuration.addAllowedHeader("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  // @Bean
  // public UserDetailsService userDetailsService(UserRepository userRepository){
  // return email -> userRepository.findByEmail(email).get();
  // // .orElseThrow(()->new UsernameNotFoundException("User not found")) ;
  // }

  // @Bean
  // public AuthenticationProvider authenticationProvider (){
  // DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
  // provider.setUserDetailsService(userDetailsService);
  // provider.setPasswordEncoder(bCryptPasswordEncoder());
  // return provider;
  // }

}
