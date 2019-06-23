package dk.lldata.demo.openapi3.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import dk.lldata.demo.openapi3.HelloService
import org.apache.cxf.jaxrs.swagger.ui.SwaggerUiConfig
import org.apache.cxf.Bus
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.openapi.OpenApiFeature
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApacheCxf(
    val bus: Bus,
    val objectMapper: ObjectMapper,
    val helloService: HelloService
) {
  @Bean
  fun jsonProvider() = JacksonJsonProvider(objectMapper)

  @Bean
  fun rsServer(): Server {
    val endpoint = JAXRSServerFactoryBean()
    endpoint.bus = bus
    endpoint.setServiceBeans(listOf(helloService))
    endpoint.address = "/"
    endpoint.features = listOf(createOpenApiFeature())
    endpoint.providers = listOf(jsonProvider())
    return endpoint.create()
  }

  @Bean
  fun createOpenApiFeature(): OpenApiFeature {
    val openApiFeature = OpenApiFeature()
    openApiFeature.isPrettyPrint = true
    openApiFeature.title = "Spring Boot CXF REST Application"
    openApiFeature.contactName = ""
    openApiFeature.description = ("How to configure Spring Boot to use the Apache CXF JAX-RS implementation, Jackson for JSON and OpenAPI v3 documentation")
    openApiFeature.version = "1.0.0"
    openApiFeature.swaggerUiConfig = SwaggerUiConfig()
        .url("/openapi.json")
    return openApiFeature
  }
}