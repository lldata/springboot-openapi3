package dk.lldata.demo.openapi3

import io.swagger.v3.oas.annotations.*
import org.springframework.stereotype.Service
import javax.ws.rs.*
import javax.ws.rs.core.*

@Path("/")
@Service
class HelloService {
  @GET
  @Path("/hello/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  @Operation(description="Documented with OpenAPI v3 annotations")
  fun helloName(@PathParam("name") name: String) = "hello $name"

  @GET
  @Path("/json/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description="Documented with OpenAPI v3 annotations")
  fun helloJson(@PathParam("name") name: String) = Hello(name=name)
}

data class Hello(
    val greeting : String = "hello",
    val name: String
)