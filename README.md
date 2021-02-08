
Cucumber Selenium - Overall testframework leveraging the Cucumber framework with Selenium written in JAVA.
Feature File - The feature file specifies the steps in BDD language style
Hooks class - Hooks class is used to initialise the browser based on the config properties
Step Definition Feature File - Java class whereby the steps from the feature file are broken down to be coded into automation tests
Feature PageObject Class - Java class whereby the necessary HTML objects are captured as WebElements to be manipulated by the associated model class
ChromeDriver.exe - Chrome driver is necessary to run the test in chrome browser. Added the executable chrome driver in the driver folder of the project
Cucumber Reports - Cucumber has a built in report generation whereby Feature files tested are automatically written to cucumbers own reporting system
Config Properties -  Added xml file to separate the config details like base url, username, emial, password
TestData class - Added test data class to separate the test data from 


How To Run Test:-
Added tag '@reg' in the feature file.
Updated the Test runner already with the tag "@reg".  
Click on the Run button on eclipse/intellij and  we have our test run.

How to change the config:
All the necessary config separated from the code. Update the 'config.xml' as per the needs

Test Report:-
Cucumber has a built in report generation. We can find XML, JSON and HTML reports 

Note:-

Completed the scenario but couldnt test after the sign in steps due to issue with the sign in. 
Unable to login to gumtree successfully due to some security issue.
Tried below option to solve it but nothing worked out. 
 options.addArguments("--disable-web-security");
 options.addArguments("--allow-running-insecure-content");
