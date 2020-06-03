# Spring Cloud Eureka, Hystrix and Zuul project

## Components
- `eureka-service` - The Eureka service which is the Service Registry
- `backoffice` - The Service which is going to give data to the backoffice.
- `zuul-service` - This is the Gateway/Edge Service which is registered with Eureka and routes the requests to Client and Server using Eureka Service.
- `commons` - Commons module to share the model between all services 
