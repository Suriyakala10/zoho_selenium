# zoho_selenium
Zoho Selenium Tests (This project has been created part of the coding exercise for Zoho Show).

* The test runner framework used is TestNG. 
* The stable version Selenium/WebDriver is used for creating the test cases for Web Appication. 
* Refer ./pom.xml file for dependencies.

The project uses page object pattern, each page has its own locators and associated methods.

Common utilities can be found under utils package.

## Configurations

Modify [regressions.xml] (testng/regressions.xml) file under testng for running one or multiple TestNG test cases.

Modify [develop.properties] (resources/develop.properties) to change the chromedriver path.

## Running test
To run the tests use from you command line or any of your favorite IDE like IntelliJ IDEA.
```
mvn clean test -P automation
```
## Reports
A report sample can be found under report (.reports) directory.

You can also check [reports] (target/surefire-reports) for additional reports.
