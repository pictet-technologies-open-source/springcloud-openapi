package com.pictet.training_springcloud.consumer.feign;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HomemadeConfiguration {

    @Bean
    public PPAuthInterceptor ppAuthInterceptor() {
        return new PPAuthInterceptor();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
