RydApp Test Automation Project Description:

1. It is Gradle-TestNG based Data-Driven java Project

2. It is followed page object model design pattern(Each page will have corresponding class and This class will find the  Elements of that page and also contains methods which perform operations on those elements.)

3. Automation framework is designed in a parametrized way. This means that the tests can theoretically be run in any environment just by changing the relevant parameters (in practice there will need to be some modifications to take into account different environmental structures).

4. Automation framework is designed in a such way that it is very easy to automate remaining or new test cases as i have created common functions across all Scripts. For adding new testcase, just need to add test case name in testdata.xls and create method with testname in test classes by calling existing common methods.

5. Selenium is used for Web Automation.

6. Build.gradle contains all basic dependencies required for web automation project.

7. TestNG.xml contains tests needs to be executed.


 
# selenium-web-automation-gradle

## Technology:
- Tool: selenium
- IDE: IntelIJ
- Build tool: Gradle
- Language: Java
- Framework: TestNG

## Prerequisite:
1. Need to install jdk 1.8 or above
2. Need to install gradle --https://gradle.org/install/
3. Make sure you have google chrome in your machine
3. Need good Internet connectivity


## Run the automation script:
1. Open cmd to the project folder
2. run testng.xml file
3. Selenium will open the browser and start automation.


