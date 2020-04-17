# Questions-webservice
A java spring boot webservice managing 20 featured questions initially loaded from stackoverflow.

## Architecture decisions
This webservice is based on the onion model from palermo to seperate the domain core from the rest of the application.
Therefore this webservice has a domain layer, a repository layer, a service layer and a layer for the controllers and the REST api itself.

## Additional libraries
Besides the Spring framework the following tools were used for this project:
* Jacoco: Generates a test coverage report as html file after packaging with maven. The html file can then be found in target/site/jacoco/index.html.
* H2 database: Provides an in memory database to persist the featured questions from stackoverflow.

## How to build and run
* Build it with `mvn clean install`
* Run the jar file **target/swagger-spring-1.0.0.jar** with `java -jar swagger-spring-1.0.0.jar

## Additional information
* When running, one can access the database page with "localhost:8080/h2-console". The information needed is the class with "org.h2.Driver", url is "jdbc:h2:mem:testdb", name is "sa".
* The index page available at localhost:8080/ shows the Swagger REST API documentation
* The project skeleton was generated with the Swagger Editor and the OpenAI file **openapi.yaml** which can be found in the root folder.
* When using the REST API make sure your REST calls include an accept header containing json.



