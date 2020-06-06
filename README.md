# Spring Cloud Eureka and Zuul project

## Components
- `eureka-service` - The Eureka service which is the Service Registry
- `backoffice` - The Service which is going to give data to the backoffice.
- `zuul-service` - This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service.
- `commons` - Commons module to share the model between all services 

## How to install and deploy
You must go to the root of the project. I.e: c:\dev\flexit
### Mongo with Docker 
The Dockerfile calls to mongo-init.js to set user/pass and employees info. Execute these commands 
```shell script
docker build -t mongo-sample-data:3.4 .
docker run --name mongo-sample-data -p 27017:27017  --restart=always -e MONGO_INITDB_DATABASE=application -d mongo-sample-data:3.4
```
### SpringBoot microservices with Docker
You need to build and run `eureka, zuul and backoffice` with Docker 
 
 #### In eureka directory
```shell script
docker build -t eureka .
docker run --name eureka -d eureka -p 8070:8070  --volume "$HOME"/.m2:/root/.m2
```

 #### In zuul directory
```shell script
docker build -t zuul .
docker run --name zuul -d zuul -p 8070:8070  --volume "$HOME"/.m2:/root/.m2
```

 #### In backoffice directory
```shell script
docker build -t backoffice .
docker run --name backoffice -d backoffice -p 8070:8070  --volume "$HOME"/.m2:/root/.m2
```