## How to start android tests locally:

- Run emulated android device in AVD Manager
- Start Appium server
- Start tests:

Local start  
**native:**
mvn clean test -P native  
**web:**
mvn clean test -P web

To work in EPAM cloud you have to put your unique token to pom.xml file to "token" tag.  
If you want to run native tests in EPAM cloud, you should manually install EPAMTestApp before.

**native:**  
Android Native: mvn test -P AndroidCloudNative  
iOS Native: mvn test -P iOSCloudNative


**web:**  
Android Web: mvn test -P AndroidCloudWeb  
iOS Web: mvn test -P iOSCloudWeb