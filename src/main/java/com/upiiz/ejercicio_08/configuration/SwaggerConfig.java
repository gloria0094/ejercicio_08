package com.upiiz.ejercicio_08.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Proveedores",
                description = "Documentación oficial de la API REST para el manejo de proveedores con Spring Boot y H2",
                termsOfService = "https://www.upiiz.ipn.mx/terminos",
                contact = @Contact(
                        name = "Gloria Leticia Gonzalez",
                        email = "ggonzalest2201@alumno.ipn.edu.mx",
                        url = "https://www.upiiz.ipn.mx"
                ),
                license = @License(
                        name = "Licencia MIT",
                        url = "https://opensource.org/licenses/MIT"
                ),
                version = "1.0.1"
        ),
        servers = {
               // Servidor en producción (Render) - ¡Debe ir primero para que sea el valor por defecto!
                @Server(url = "https://ejercicio-08-btry.onrender.com", description = "Servidor Producción Render"),
                @Server(url = "http://localhost:8080", description = "Servidor Local")
        }
)
public class SwaggerConfig {
}
