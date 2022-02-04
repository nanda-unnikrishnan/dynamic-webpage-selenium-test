
### Solution
- This solution is built based on PageObjectModel design pattern.
- Implementation is using Selenium WebDriver(with Java) for scripting, Maven for build and TestNG for execution.
- Selecting and navigating to the first challenge is tested under `ChallengesTest#selectFirstChallengeTest`
- Additionally, login functionality test is written under `LoginPageTest`

### Data and Configuration files

- Below configurations are provided in config.properties file.
  - browser
  - location of the associated WebDriver
  - login email and password (for happy path scenarios)
  
  These properties can be overriden while running from the command line (using -DpropertyName=propertyValue).
  `eg. -Dbrowser=chrome`
  
- An excel data file facilitates the input for data driven testing of the Login functionality.
  The data file name can also be overriden while running from the command line (using -DpropertyName=propertyValue syntax).
  `eg. -Dtestdata.filename=<New file name>`

## Test execution

1. Clone https://github.com/nanda-unnikrishnan/dynamic-webpage-selenium-test
2. Go to directory *dynamic-webpage-selenium-test*
3. Execute below command which uses Maven (needs to be installed prior) after updating chrome driver location
```
mvn clean test -Dchrome.driver.location=<location_of_chromedriver>
```

You could override browsers to firefox/chrome by passing arguments for browser and driver location.
For Chrome:
```
mvn clean test -Dbrowser=chrome -Dchrome.driver.location=<location_of_chromedriver>
```

For Firefox:
```
mvn clean test -Dbrowser=firefox -Dfirefox.driver.location=<location_of_geckodriver>
```

Run a specific test case:
```
mvn clean test -Dbrowser=chrome -Dchrome.driver.location=<location_of_chromedriver> -Dtest=ChallengesTest#selectFirstChallengeTest
```

4. Test outputs
   - TestNG's html report will be present in the test-output folder.
   - Screenshots will be present in the *screenshots* folder.
