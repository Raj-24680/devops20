FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/classes /app
CMD ["java", "org.bnmit.demo.App"]
