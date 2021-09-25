How to start android tests locally:

Run emulated android device in AVD Manager
Start Appium server
Start tests:

native
mvn clean test -P native

web
mvn clean test -P web