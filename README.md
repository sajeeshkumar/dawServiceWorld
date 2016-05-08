Pre-requisites: JDK 1.8, maven

a) unzip folder
b) cd dawServiceWorld
c) mvn clean jetty:run

Use postman to execute test cases or curl

curl http://localhost:8080/api/recent_purchases/Tom34

The first time request is handled by making backend calls. Subsequent REST API calls are cached. There is a TTL setting for the cache and is defined ehcache.xml
