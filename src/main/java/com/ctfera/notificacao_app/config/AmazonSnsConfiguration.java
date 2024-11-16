package com.ctfera.notificacao_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSnsConfiguration {

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("@aws.secretKey")
    private String secretKey;
}
