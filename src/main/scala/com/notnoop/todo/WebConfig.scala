package com.notnoop.todo

import com.mongodb.Mongo
import java.net.UnknownHostException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration @EnableWebMvc @ComponentScan(basePackages = Array("com.notnoop.todo"))
class WebConfig extends WebMvcConfigurerAdapter {

    override def addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("**/*.html").addResourceLocations("/")
        registry.addResourceHandler("**/*.js").addResourceLocations("/")
        registry.addResourceHandler("**/*.css").addResourceLocations("/")
        registry.addResourceHandler("**/*.png").addResourceLocations("/")
    }

    @Bean
    def mongo() /*throws UnknownHostException*/ = {
        new Mongo("localhost")
    }

    @Bean
    def mongoTemplate() /*throws UnknownHostException*/ = {
        new MongoTemplate(mongo(), "todo")
    }

}
