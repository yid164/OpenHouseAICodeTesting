# OpenHouseAICodeTesting
Spring Boot App for doing OpenHouse.AI Code Interview

### Problem Description

Create a Spring Boot app, Flask app, or use a similar framework that you prefer, as a RESTful Web Service to consume, store, and process logs from a frontend application and to make the stored logs retrievable for batch processing.

The FE will be sending logs every 5 minutes from up to 100 users. The logs will need to be retrieved in large volumes on a weekly basis for batch processing. A sample log is available in this folder. The logs should be retrievable by any combination of user, time range and log type. The response should be a list of logs


### Problem Solutions: 

1. Should construct some entities: 

    a. Users: userId, sessionId, actions

    b. Actions: time, type, properties

    c. Properties: locationX, locationY, viewId, pageFrom, pageTo

2. Restful API (Put, `Post`, `Delete`, `Get`), for safety, I will not implement the PUT request

3. Database: `MongoDB`

4. Testing: `Postman`, and `MongoDB Compass`

![Image description](./Screen%20Shot%202020-04-10%20at%201.23.39%20PM.png)

### Solution Details:

1. Database, it has been hold on my database (MongoDB), so you do not need setup the database

2. URL: `localhost:8080/rest`

3. Post: add the JSON format on the URL: localhost:8080/rest

4. GET: 

    a. Get all: `localhost:8080/rest`
    
    b. Get one: `localhost:8080/rest/'userId'`
    
5. Delete: `localhost:8080/rest/'userId'`

### How to run: 
    
    Before you run it, please make sure your port: 8080 is clear
    command on the the main reposiroty in Terminal: 
    
    $ mvn spring-boot:run



