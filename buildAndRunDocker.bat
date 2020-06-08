REM These file run only Backoffice containers
REM You need to run the angular container from flexit-app repository

REM Stop all containers
@ECHO OFF
FOR /f "tokens=*" %%i IN ('docker ps -q') DO docker stop %%i

REM Mongo build and run
docker build -t mongo-sample-data:3.4 .
docker run --name mongo-sample-data -p 27017:27017 -d --restart=always -it --hostname mongodb --name=mongodb --net=bridge --expose=27017 mongo-sample-data:3.4

REM Eureka build and run
cd eureka
docker build -t eureka .
docker run --name eureka -p 8070:8070 -d eureka --volume "$HOME"/.m2:/root/.m2
cd ..

REM Zuul build and run
cd zuul
docker build -t zuul .
docker run --name zuul -p 8079:8079 -d zuul --volume "$HOME"/.m2:/root/.m2
cd ..

REM backoffice
cd backoffice
docker build -t backoffice .
docker run --name backoffice -p 8071:8071 -d --link=mongodb backoffice
cd ..