package com.banque.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;


@Configuration
public class JaxWSserverConfig
{
    @Bean // Pour que spring le prend en charge lors du demarage
    SimpleJaxWsServiceExporter simpleJaxWsServiceExporter()
    {
        SimpleJaxWsServiceExporter jaxWSserver = new SimpleJaxWsServiceExporter();
        jaxWSserver.setBaseAddress("http://0.0.0.0:8087/");
        return jaxWSserver;
    }
}
