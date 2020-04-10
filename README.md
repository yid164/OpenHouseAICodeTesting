# OpenHouseAICodeTesting
Spring Boot App for doing OpenHouse.AI Code Interview

### Problem Description

Create a Spring Boot app, Flask app, or use a similar framework that you prefer, as a RESTful Web Service to consume, store, and process logs from a frontend application and to make the stored logs retrievable for batch processing.

The FE will be sending logs every 5 minutes from up to 100 users. The logs will need to be retrieved in large volumes on a weekly basis for batch processing. A sample log is available in this folder. The logs should be retrievable by any combination of user, time range and log type. The response should be a list of logs


### Problem Solution: 

1. Should construct some entities: 

    a. Users: userId, sessionId, actions

    b. Actions: time, type, properties

    c. Property: locationX, locationY, viewId, pageFrom, pageTo

2. Restful API (Put, Post, Delete, Get)

3. Database: MongoDB


