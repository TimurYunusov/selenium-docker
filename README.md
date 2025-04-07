# Selenium Docker Test Automation Framework

## Overview

This is a Test Automation Framework built using Java, Selenium WebDriver, and TestNG. It supports local execution and can be extended for Docker-based grid execution. The project is structured for scalability, maintainability, and CI/CD integration with Jenkins.

## Tech Stack

- Java 21
- Selenium 4
- TestNG
- Maven
- WebDriverManager
- Logback (for logging)
- GitHub
- Jenkins (for CI/CD)

## Project Structure

. ├── src │ ├── main │ │ └── java # Page objects, utilities │ └── test │ └── java # Test classes ├── target # Compiled test outputs and reports ├── pom.xml # Maven project file ├── .gitignore └── README.md

shell
Copy
Edit

## How to Run Tests

### Run all tests locally

```bash
mvn clean test
Run specific test suite
bash
Copy
Edit
mvn clean test -DsuiteXmlFile=src/test/resources/test-suites/flight-reservation.xml
This command runs the tests defined in the specified TestNG suite XML file.

Reports
After test execution, open the following report in a browser:

bash
Copy
Edit
target/test-output/index.html
Customization
To change browser, modify the system property in pom.xml under maven-surefire-plugin.

Environment-specific configs (like Selenium Grid toggle) are also set in the pom.xml.

Future Enhancements
Add Docker support for Selenium Grid execution.

Integrate Allure or ExtentReports for richer reporting.

Add support for parallel execution and environment-based test runs.

Author
Timur Yunusov
GitHub: https://github.com/TimurYunusov
