package com.pictet.training_springcloud.consumer.feign;

import com.pictet.training_springcloud.consumer.exception.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    private ErrorDecoder.Default defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        if (status.is4xxClientError()) {
            return new ResourceNotFoundException();
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
