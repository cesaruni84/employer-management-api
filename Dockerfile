# Usa la imagen base de OpenJDK 11 con Maven
FROM maven:3.8.4-openjdk-11-slim AS builder

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia los archivos de la aplicación y del proyecto Maven
COPY pom.xml .
COPY src ./src

# Empaqueta la aplicación usando Maven
RUN mvn clean package -DskipTests

# Usa la imagen base de OpenJDK 11
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido por Maven a la imagen
COPY --from=builder /app/target/spring-boot-employer-management-api-0.0.1-SNAPSHOT.jar /app/api-test.jar

# Expone el puerto 8080, que es el puerto por defecto para las aplicaciones Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "/app/api-test.jar"]