# Selenium Test Automation Project - Katalon demo page - CURA Healthcare Service

This repository contains a Java project for automating tests using Selenium WebDriver,
Maven, and TestNG to test demo page for medical appointments [CURA Healthcare Service](https://katalon-demo-cura.herokuapp.com/).<br />
Project follows the Page Object Model (POM) design pattern, providing a structured and maintainable
framework for automating UI tests.</br>Page objects are located in the `src/main/java/pages` directory.
You can extend or modify them to accommodate changes in the application.<br />

The tests are categorized into the following sections:

- [**Visit LoginPage Tests:**](test_cases/visit_login_page_tests.md) Test different buttons for login page
- [**User Login Tests:**](test_cases/user_login_tests.md) Verify login functionality
- [**Make Appointment Tests:**](test_cases/make_appointment_test.md) Test medical appointment functionality
- [**Check History Page Tests:**](test_cases/check_history_page_tests.md) Test appointment information on history page

### Prerequisites

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- WebDriver compatible with your preferred browser (Chrome, Firefox, etc.)

Run tests from command line with: mvn clean test -Dsurefire.suiteXmlFiles=testng.xml</br>
Cross-browser testing is provided for Chrome, Edge and Firefox. 
