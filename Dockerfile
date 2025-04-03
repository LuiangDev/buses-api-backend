# Usar imagen base de Java 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo
WORKDIR /app

# Copiar el archivo jar generado
COPY target/buses-api-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
