FROM eclipse-temurin:17-jre
LABEL maintainer="darasurya81@gmail.com"
WORKDIR /springboot-demo
COPY target/springboot-demo-1.0.0.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar"]