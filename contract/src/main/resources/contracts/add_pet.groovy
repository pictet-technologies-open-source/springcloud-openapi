package contracts.petstore

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url(value(consumer(regex("/api/pet"))))
        cookies {
            cookie 'SPPAUTH': 'usercookie'
        }
        headers {
            header 'Content-Type': 'application/json'
        }
        body '{"id":2,"name":"Woulfie"}'
    }
    response {
        status OK()
    }
}