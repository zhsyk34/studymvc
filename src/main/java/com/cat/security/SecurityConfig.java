//package com.cat.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user").password("password").roles("USER");
//    }
//}