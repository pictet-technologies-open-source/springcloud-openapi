package com.pictet.training_springcloud.consumer.feign;

import com.pictet.training_springcloud.petstore.api.PetstoreApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "petstore", url = "${petstore.url}", configuration = HomemadeConfiguration.class)
public interface PetStoreClient extends PetstoreApi {
}
