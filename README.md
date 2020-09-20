Shawn Au Code Challenge

Run using the command
mvn spring-boot:run
or
./mvnw spring-boot:run
- might need to install mvn

List of calls:

GET /check-list

PUT /check-list/add

- accepts input in body

DELETE /check-list/{index}

Please read CheckListEndpoint.java file for more information regarding each call.

Example calls:

curl 'http://localhost:8080/check-list/add' -X PUT \
--header 'Content-Type: text/plain' \
--data-raw 'test'

curl 'http://localhost:8080/check-list'

curl 'http://localhost:8080/check-list/0' -X DELETE
