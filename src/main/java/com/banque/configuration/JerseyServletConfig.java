package com.banque.configuration;

import com.banque.web.CompteRestAPIJaxRS;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyServletConfig
{
    //@Bean
    public ResourceConfig resourceConfig()
    {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestAPIJaxRS.class);
        return jerseyServlet;
    }

}
