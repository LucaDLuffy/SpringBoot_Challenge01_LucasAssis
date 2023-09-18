# SpringBoot_Challenge01_LucasAssis

Car API
This project is a simple RESTful API for managing car data. It provides two endpoints: GET and POST.

Requirements
Java 17
Maven
MySQL (with a database named "db_car," root user, and root password)

Endpoints
POST /carros
Create a new car entry in the database with the following payload:

Copy code
{
    "idChassi": 123,
    "name": "New Party",
    "brand": "Ford",
    "color": "blue",
    "manufactureYear": "2014/2015"
}
Rules
The "brand" field should only accept brands (Ford, Chevrolet, BMW, Volvo). If a different brand is sent, an exception will be thrown, and the request will not be successful.

The payload above should be saved in the database.

Null values should not be saved in the database or returned in DTOs (Data Transfer Objects) for input or output. This validation should occur, and in case of null, a handled exception should be thrown

GET /carros/{idChassi}
Retrieve a car by its idChassi. Returns the corresponding car registered during POST.

Author
Lucas Da Silva Assis
