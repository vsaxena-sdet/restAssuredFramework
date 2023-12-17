# Rest Assured Automation Framework

This repository contains a sample Rest Assured automation framework built on Java using TestNG and Maven. The framework is designed to facilitate API testing, making it easy to write and execute tests for RESTful APIs.

## Features

- **Java:** The framework is developed using Java, making it platform-independent and widely supported.
- **Rest Assured:** Utilizes the Rest Assured library for simplifying API testing and validation.
- **TestNG:** TestNG is used as the testing framework for efficient test organization and execution.
- **Maven:** Maven is employed for project management and dependency resolution, making it easy to set up and run the project.
- **Log4j:** Integration with Log4j for comprehensive logging and reporting capabilities using Report Portal.

## Prerequisites

Ensure you have the following tools installed on your machine:

- Java Development Kit (JDK) - 11
- Maven
- Your preferred IDE (Eclipse, IntelliJ, etc.)

## Getting Started

1. Clone the repository:

   ```bash
      git clone https://github.com/vsaxena-sdet/restAssuredFramework.git
   
2. Navigate to the Repository:
   ```bash
      cd rest-assured-automation-framework
   
4. Build the project:
   ```bash
      mvn clean install
   
5. Run the test
   ```bash
      mvn test

## Report Portal
  - Setup Report Portal Using docker on a local machine or any other cloud server. Refer to [this](https://reportportal.io/docs/installation-steps/DeployWithDockerOnLinuxMac) link for help.
  - Update the reportPortal.properties file with the uuid,hostname and project name
  - Run the tests using maven to see reports in the report portal.

