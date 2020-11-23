# KneatSoftwareChallenge/Jader-Cunha
This is a challenge for the QA Sr. position at Kneat.

## Requirements
Java Development Kit (JDK) installed, minimum required version is 14.

**Design Pattern:** Page Object Model with loadable components<sub><sup>(POC)</sub></sup> & AAA  
**Following tools were used in this framework:**  
Java 14, Selenium, TestNG, Cucumber, Gradle, SeleniumGrid, WebDriverManager, BrowserStack

## ABOUT PROJECT
Project made for Kneat in QA Sr. challenge.  
You don't have to download any WebDrivers - I'm using WebDriverManager, drivers will be downloaded by gradle.  
Supported tests executors:
- *Chrome*
- *Firefox*
- *Opera*
- *Safari*
- *SeleniumGrid*
- *BrowserStack*

## HOW TO RUN TESTS
There are multiple ways to run tests from this build. It all depends on what do you want to do:
### TestNG
- Right click on `TestNG.xml` file, and Run ->  This will run all tests attached to specific xml runner
- In terminal type `./gradlew test` -> This will run all tests from tests package.`(src/test/java/tests)`  
You can add some environment settings, before you run tests, e.g:
   - `-Dtests.executor="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Safari, GRID, BrowserStack   
  <sub>_**This is the best option to run tests, all tools, features are working well while running tests via this commend**_</sub>
### Cucumber
- Right click on `.feature` file, and Run -> This will run `.feature` file on default settings
- In terminal type `./gradlew cucumber` -> This will run all `.feature` files on default settings  
You can add some environment settings, before you run tests, e.g:
   - `-Dtests.executor="YOUR_HOST_NAME"` -> available hosts: Chrome, Firefox, Opera, Safari, Safari, GRID, BrowserStack
- In terminal type `./gradlew cucumber -Dcucumber.filter.tags="@YOUR_TAG"` -> This will run all `.feature` scenarios which provided tag
- Right click on `CucumberRunner` file, and Run -> This will run all `.feature` files on default settings
  - <sub><sup>*This is highly unrecommended option since it's an experimental file and doesn't work well, check build.gradle for more information*</sup></sub>
- Create your own runner :hammer_and_wrench:
## Localhost
After each LOCAL cycle run two types of log information are saved inside repository, together with tests results
### TestNG & Cucumber
- Detailed logs in logs directory
- Colorful logs in testdata.xlsx file
- Allure HTML report in build/allure-results directory

In terminal type `allure generate build/allure-results --clean` to generate Allure tests results   
<sub><sup>*Allure tests results available for running tests via: CucumberRunner, `./gradlew test` or TestMethod with annotation @Test (src/test/java/tests)*</sup></sub>
## SELENIUM GRID (POC)
### HOW TO RUN TESTS
1. Run SeleniumGridRunner
2. Make sure that SeleniumGrid is running properly, check http://localhost:4444/grid/console
3. In terminal type `./gradlew test -Dtests.executor=grid -Dremote.browser="YOUR_REMOTE_BROWSER"`