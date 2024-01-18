# Advent of Code

Advent of Code is an Advent calendar of small programming puzzles for a variety of skill sets and skill levels that can be solved in any programming language

This repository contains a REST API which have the day wise solution of puzzles on Advent grouped together ***yearly***.

OpenAPI specification for the API can be accessed below: 

<a href="https://app.swaggerhub.com/apis/PERSDEV/advent-of-code-api/1.0.0" target="_blank" rel="noopener noreferrer">
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white" />
</a>

### Usage

Use [maven](https://maven.apache.org/download.cgi) to build the backend.

```bash
mvn clean package
```

This will build and package the application which can be then run using the fat jar.

OR

If using IDE, like IntelliJ or Eclipse, you can run the application from main class `AdventOfCodeApplication`, the application will come up on port `28080`

If you want to change port or any other application property, then go to `application.yml` in resources folder.

### Postman import

The postman collection for the API is added in the `/docs` directory which can be imported in Postman directly to run the API.
