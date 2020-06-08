# Spring Cloud Eureka and Zuul project

## Components
- `eureka-service` - The Eureka service which is the Service Registry
- `backoffice` - The Service which is going to give data to the backoffice.
- `zuul-service` - This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service.

## How to install and deploy
You must go to the root of the project. I.e: c:\dev\flexit
### Mongo with Docker 
The Dockerfile calls to mongo-init.js to set user/pass and employees info. Execute these commands 
```shell script
docker build -t mongo-sample-data:3.4 .
docker run --name mongo-sample-data -p 27017:27017 -d --restart=always -it --hostname mongodb --name=mongodb --net=bridge --expose=27017 mongo-sample-data:3.4
```
### SpringBoot microservices with Docker
#### Disabled
Due to connectivity problems between the Backend containers and the Frontend containers, it is not possible to start the back services using Docker.

### SpringBoot microservices 

To start the application, the following steps must be followed:

- run `mvn clean install` in every directory (eureka, zuul and backoffice)
- run `java -jar eureka-1.0-SNAPSHOT.jar` in eureka\target directory
- run `java -jar zuul-1.0-SNAPSHOT.jar` in zuul\target directory
- run `java -jar backoffice-1.0-SNAPSHOT.jar` in backoffice\target directory

### How to run frontend

You can read the README.md in the flexit-app repository