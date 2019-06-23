# OpenAPI v3 demo

Motivation: Demonstrate that Spring Boot can generate OpenAPI v3 documentation

The following technologies are used:
* Spring Boot
* Kotlin
* Apache CXF (JAX-RS framework)
* Apache CXF OpenAPI v3 feature
* Jackson as JSON provider 

### Demo

To start the application use Java 8+ (I used Java 11):
```
./gradlew bootRun
```

Now start a browser and try the following URLS:
* http://localhost:8080/hello/johndoe
* http://localhost:8080/json/johndoe
* http://localhost:8080/openapi.json
* http://localhost:8080/api-docs/?url=/openapi.json

### Documentation links

Helpful documentation:
* https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples/jax_rs/spring_boot
* http://cxf.apache.org/docs/openapifeature.html
* https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations
