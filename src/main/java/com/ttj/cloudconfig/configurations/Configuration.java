package com.ttj.cloudconfig.configurations;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.virtual-host}")
    private String vhost;
    @Value("${spring.rabbitmq.username}")
    private String user;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.port}")
    private int port;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        System.out.println("rmqhost is " + host);
        factory.setHost(host);
        factory.setVirtualHost(vhost);
        factory.setUsername(user);
        factory.setPassword(password);
        factory.setPort(port);
        return factory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
}
