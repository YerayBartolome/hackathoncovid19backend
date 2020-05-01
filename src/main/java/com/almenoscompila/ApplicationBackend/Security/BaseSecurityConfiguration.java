package com.almenoscompila.ApplicationBackend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

//@SuppressWarnings("deprecation") // bruh
@EnableWebSecurity
public class BaseSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    private static final String USERS_QUERY = "select username, password, enabled from registered_user where username = ?";

    private static final String AUTHORITIES_QUERY = "select username, role from authorities where username = ?";

    public BaseSecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/style/**").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/paginaPrincipal","/","/golafre", "/inicio").permitAll()
                .antMatchers("/random").permitAll()
                .antMatchers("/receta/**").permitAll()
                .antMatchers("/buscaPorTag/**").permitAll()
                .antMatchers("/resultadoBusqueda").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/usuario/**").permitAll()
                .antMatchers("/registerUser").permitAll()
                .antMatchers("/creadorDeReceta").hasRole("USER")
                .antMatchers("/imageUploader").hasRole("USER")
                .antMatchers("/uploading").hasRole("USER")
                .anyRequest().authenticated()

                .and()
                .formLogin() //to use forms (web)

                .and()
                .httpBasic() //to use http headers REST
                .and()

                .rememberMe()
                .tokenValiditySeconds(2419200)
                .key("tecnocampus")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //needed only when csrf is enabled (as by default is post)
                .logoutSuccessUrl("/"); //where to go when logout is successful

        http
                .csrf().disable()
                .headers()
                .frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY);


    }

}
