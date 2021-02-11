package com.pictet.training_springcloud.consumer.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PPAuthInterceptor implements RequestInterceptor {

    public static Logger LOGGER = LoggerFactory.getLogger(PPAuthInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        LOGGER.debug("Add SPPAUTH cookie.");
        template.header("Cookie", "SPPAUTH=usercookie");
    };
}
