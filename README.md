# Read Me First
Bring up the Postgres database using the command<br>

`sudo docker-compose -f ./dev-tool/docker-compose-ut.yml up -d`
# Getting Started

##To run tests
`mvn test` <br>

##To build and execute
To build the application run the below command.
`mvn clean package` <br>

Once the artifact is ready the run 
`java -jar ./target/train-problem-0.0.1-SNAPSHOT.jar` <br>

The below URL can be used to access the APIs
http://localhost:8080/swagger-ui.html

