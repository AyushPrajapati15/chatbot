# Use an official JDK image to build and run the app
FROM eclipse-temurin:17-jdk-alpine
COPY . .
# Add this line to fix the permission error:
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/chatbot-0.0.1-SNAPSHOT.jar"]