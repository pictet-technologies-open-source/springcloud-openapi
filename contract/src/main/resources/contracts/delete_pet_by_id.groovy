package contracts.petstore

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'DELETE'
        url(value(consumer(regex("/api/pet/\\d+"))))
        cookies {
            cookie 'SPPAUTH': 'usercookie'
        }
    }
    response {
        status OK()
    }
}