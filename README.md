# zoho_selenium
Zoho Selenium Tests (This project is created part of the coding exercise for Zoho Show).

The test runner framework used is TestNG. The stable version Selenium/WebDriver is used for creating the test cases for Web Appication. Refer ./pom.xml file for dependencies.

The project uses page object pattern, each page has its own locators and associated methods.

Common utilities can be found under utils package.



To run the tests use
```
mvn clean test
```

