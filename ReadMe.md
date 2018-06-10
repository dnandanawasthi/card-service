Steps to run card-service application

Command to build application: mvn clean install

Command to build docker image of application: mvn clean package docker:build

Command to build run docker image: docker run -it -p 8080:8080 card-service

Command to stop all the container docker stop $(docker ps -a -q)

Command to remove all the container docker rm $(docker ps -a -q)

Command to remove all the image docker rmi -f $(docker images -q)

Below are the sample URLs to test application using Postman or browser


http://localhost:8080/card-service/card/addcard

Body:
{
    "id" : "1",
    "userName" : "nandan",
    "cardNumber" : "12345",
    "expiryDate" : "28/12/1987",
    "email" : "nandan@gmail.com"
}


http://localhost:8080/card-service/card/cardbynumber/12345

For XML response
http://localhost:8080/card-service/card/cardbynumber/12345?mediaType=xml

For Json response
http://localhost:8080/card-service/card/cardbynumber/12345?mediaType=json

