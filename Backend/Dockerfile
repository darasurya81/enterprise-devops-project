FROM openjdk:17-jdk-slim
LABEL maintainer="darasurya81@gmail.com"
WORKDIR /app
COPY target/springboot-demo-1.0.0.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]