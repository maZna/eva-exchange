# eva-exchange

### Description

A demo backend application for EvaExchange. Users can use this application's API to test buy and sell transactions for various share stocks. The application uses the **Spring Framework** for developing the backend, **MYSQL** as a database, and **Docker** for containerization.

### Requirements

In order to run the application locally, the following tools must be installed and ready:

- Docker
- Docker compose

### Environment Setup

Docker and Docker Compose need to be setup on the host machine in order to run the service. Installation instructions for Docker can be found [here](https://docs.docker.com/get-docker/). Installation instructions for Docker Compose can be found [here](https://docs.docker.com/compose/install/)

### Running the Service

The service can be run by running the following command in the terminal:

```
docker-compose up --build && docker-compose rm -fsv
```

Or it can be run in detached mode by running the follwing command:

```
docker-compose up -d --build
```

and then running the following to perform a clean shutdown:

```
docker-compose down
```

Once running, the application interface can be accessed at http://localhost:3000/\*\*. The service endpoints can be accessed at http://localhost:8081/.

Its as simple as this! :smile:

### Documentation

Service documentation related to API end points can be accessed at http://localhost:8081/swagger-ui.html when the service is running.

The service is initialized with five shares - ACQ, BHF, QKM, SFJ, and VQC - on startup. The shares have a pre-determined share price which stays the same throughout the life of the program. Five user portfolios with ids - 13432, 13452, 13524, 13622, and 13679 -  are present. These initial values can be used while calling the API. A sample postman collection is also present in the root directory of the application.

### Authors

This repository and all its contents have been compiled and written by Masna Ahmed ([Github](https://github.com/maZna), [LinkedIn](https://www.linkedin.com/in/masna-ahmed/)). Please feel free to contact me for ideas, suggestions, and/or questions.

Business Email: masnaahmed1998@gmail.com

