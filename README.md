# FEEL Expression Evaluator Service

This project provides a RESTful service that evaluates FEEL (Friendly Enough Expression Language) expressions using the Camunda FEEL engine.

## Requirements

- **Java**: 21
- **Spring**: 3.3
- **Camunda FEEL Engine**: Latest, see link below

## API Endpoints

### Evaluate FEEL Expression

**POST** `/api/feel/evaluate`

This endpoint evaluates a given FEEL expression with optional variables.

**Example Payload**

**Request:**

```json
{
  "expression": "\"Hello, World!\"",
  "variables": {}
}
```


## TO DO

- Incomplete FEEL Engine Configuration: The current setup of the FEEL engine is not fully configured.

- **Challenge:** This project offers a nice challenge for anyone trying to fully integrate the Camunda FEEL engine into a Spring Boot application and leverage its full capabilities. Feel free to explore the engine's builder options and extend the functionality.

## DOCUMENTATION

- Library developers guide: https://camunda.github.io/feel-scala/docs/developer-guide/
- Maven Repository: https://mvnrepository.com/artifact/org.camunda.feel/feel-engine
