# Spring Cloud Eureka and Zuul project

## Components
- `eureka-service` - The Eureka service which is the Service Registry
- `backoffice` - The Service which is going to give data to the backoffice.
- `zuul-service` - This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service.
- `commons` - Commons module to share the model between all services 

## How to install and deploy
### Mongo with Docker 
The Dockerfile calls to mongo-init.js to set user/pass and employees info. You need to execute these commands. 
- `docker build -t mongo-sample-data:3.4 .` 
- `docker run --name mongo-sample-data -p 27017:27017  --restart=always -e MONGO_INITDB_DATABASE=application -d mongo-sample-data:3.4`
