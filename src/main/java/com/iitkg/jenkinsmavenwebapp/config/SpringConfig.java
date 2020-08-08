/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkg.jenkinsmavenwebapp.config;
import com.iitkg.jenkinsmavenwebapp.dao.UserDAO;
import com.iitkg.jenkinsmavenwebapp.dao.UserDAOImpl;
import java.util.Set;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.ws.rs.core.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.iitkg.jenkinsmavenwebapp"})
@javax.ws.rs.ApplicationPath("rest")
public class SpringConfig extends Application implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
    
    @Override
    public Set<Class<?>> getClasses(){
    	Set<Class<?>> resource=new java.util.HashSet<Class<?>>();
    	addResourceClasses(resource);
    	return resource;    	
    }
    
    private void addResourceClasses(Set<Class<?>> resources) {
    	resources.add(com.iitkg.jenkinsmavenwebapp.controller.HelloWorldService.class);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springbootdb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");         
        return dataSource;
    }  
    
    @Bean
    public JdbcTemplate getJdbcTemplate() throws NamingException {
        System.out.println("added ssh key in github");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }
    
    @Bean
    public UserDAO getUserDAO() {
        return new UserDAOImpl(getDataSource());
    }
}