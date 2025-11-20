package com.SOAP.DemoSoap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebServiceConfig implements WsConfigurer {

    // SUPPRIME tout le @Bean messageDispatcherServlet() ← C'EST ÇA LE PROBLÈME !

    @Bean(name = "banque")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema banqueSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("BanquePort");
        wsdl.setLocationUri("/ws");                    // endpoint accessible sur /ws/*
        wsdl.setTargetNamespace("http://esmt.banque");
        wsdl.setSchema(banqueSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema banqueSchema() {
        return new SimpleXsdSchema(new ClassPathResource("banque.xsd"));
    }

    // Méthode obligatoire (vide pour l'instant)
    @Override
    public void addInterceptors(java.util.List<org.springframework.ws.server.EndpointInterceptor> interceptors) {
    }
}