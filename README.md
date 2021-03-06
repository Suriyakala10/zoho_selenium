# zoho_selenium
Zoho Selenium Tests (This project has been created part of the coding exercise for Zoho Show).

* The test runner framework used is TestNG. 
* The stable version Selenium/WebDriver is used for creating the test cases for Web Appication. 
* Refer [./pom.xml](pom.xml) file for dependencies.

The project uses page object pattern, each page has its own locators and associated methods.

Common utilities can be found under utils package.

## Configurations

Modify [regressions.xml](testng/regressions.xml) file under testng for running one or multiple TestNG test cases.

Modify [develop.properties](src/test/resources/develop.properties) to change the chromedriver path.

## Running test
To run the tests from your command line or any of your favorite IDE like IntelliJ IDEA.
Use the below command:
```
mvn clean test -P automation
```
## Reports
A sample PDF report can be found under [report](reports) directory.

You can also check generated reports under target/surefire-reports for additional reports.
