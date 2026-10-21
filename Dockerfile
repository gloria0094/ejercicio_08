# Etapa 1: Build / Compilación del proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el archivo de configuración de Maven y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos la aplicación omitiendo los tests para acelerar el despliegue
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecutar la aplicación
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el archivo JAR generado desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto estándar 8080
EXPOSE 8080

# Comando para ejecutar la aplicación de Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
