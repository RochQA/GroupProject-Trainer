FROM maven as build
WORKDIR /build
COPY pom.xml .
RUN mvn verify --fail-never
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/Trainer-0.0.1-SNAPSHOT.jar Trainer.jar
ENTRYPOINT ["java","-jar","Trainer.jar"]
