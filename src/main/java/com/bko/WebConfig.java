package com.bko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bko.domain.Member;
import com.bko.viewresolver.ExcelViewResolver;
import com.bko.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.bko.viewresolver.JsonViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bko.web")
public class WebConfig {
	
   
    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
 
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
 
        resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(jspViewResolver());
        //resolvers.add(pdfViewResolver());
        resolvers.add(excelViewResolver());
         
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
	
	@Bean
    //public ViewResolver getViewResolver(){
	public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver; 
    }
	
	/*
     * Configure View resolver to provide XML output Uses JAXB2 marshaller to
     * marshall/unmarshall POJO's (with JAXB annotations) to XML
     */
    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Member.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }
    
    /*
     * Configure View resolver to provide JSON output using JACKSON library to
     * convert object in JSON format.
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
    
    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }
 

}
