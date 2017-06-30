# AppiumTechTalk

### Appium Demo -> Appium Project
### AppiumTechTalk -> Android Project
### iOS.zip -> iOS Project

## Development Environment Setup

### Create or edit Test Cases
To open the project you will need:

* Maven 3
* IntelliJ IDEA Community Edition (Version 2016.2 recommended)

To open the project just import the project as a Maven Project.

### Run Test Cases

Make sure you have installed:

* Maven 3
* Android SDK (to run tests in Android)
* XCode 7.3.1 (to run tests in iOS)
* Appium 1.6.3 or higher (NodeJS version is recommended): `npm install -g appium` or if you want an specific version `npm install -g appium@1.6.3`
* Appium Standalone (If you have MacOS or Windows): https://github.com/appium/appium-desktop/releases/

Once you have everything in place execute Appium server. From Terminal this would be:
`appium`

Or you can specify the port to use you you can have multiple instances running on the same machine (one for Android and one for iOS):

`appium --port "4723"`

`appium --port "4725"`

### TestRail API Integration

http://docs.gurock.com/testrail-api2/start
