package contracts.petstore

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
//        url(value(consumer(regex("/api/pet/\\d+"))))
        url("/api/pet/1") {
//            queryParameters {
//                parameter("id", "1")
//            }
        }
        cookies {
            cookie 'SPPAUTH': 'usercookie'
        }
    }
    response {
        status OK()
        headers {
            contentType('application/json')
        }
        body(file('get_pet_by_id.json'))
    }
}