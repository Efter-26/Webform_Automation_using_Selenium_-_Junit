# Webform Automation Project With Selenium and Junit

## Overview
In this project, there perform web automation using Selenium as the testing tool and JUnit for the test framework. The project involves automating two web forms from the following sites:

- 1. [Digital Unite Practice Webform](https://www.digitalunite.com/practice-webform-learners)
- 2. [WP Everest Guest Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form)

Both automations handle form field inputs, calendar date selection, and final submission.

## Features
- **Automated Field Entry**: Inputs text, selects buttons, handles drop-down menus, upload file or image.
- **Calendar Automation**: Selects specific dates for handling date on Calender"
- **Assertions**: Verifies successful form submission by asserting the confirmation message.

## Tools & Technologies
- **[Selenium WebDriver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)**: Browser automation tool.
- **[JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)**: Unit testing framework.
- **Gradle**: Build tool.
- **ChromeDriver**: WebDriver for automating Chrome browser.

## Prerequisites
- **JDK Version**: 11
- **IDE**: IntelliJ IDEA
- **Build Tool**: Gradle
- **DSL**: Groovy

## Project Setup

### Clone the Repository:
```bash
git clone https://github.com/username/repository-name.git
cd repository-name
```
## Run the Test

To execute the test case, run the following command:

```bash
run WebFormAutomation1.java
run WebFormAutomation2.java
```
## Reports
After the test run, the results will be displayed in the terminal. Then the reports of Test result can be found at:

```bash
build/reports/tests/test/index.html
```
### **1. Report Of WebFormAutomation1 :**

![image](https://github.com/user-attachments/assets/e325df56-3a43-4bc3-a990-bd83cf1c410f)
![image](https://github.com/user-attachments/assets/74276815-fa36-4664-a269-a4fe1b91dee8)

### **1. Report Of WebFormAutomation2:**

![image](https://github.com/user-attachments/assets/f3f4a74b-a13a-4960-8dda-bf1e1e6a67bc)
![image](https://github.com/user-attachments/assets/9aa089c1-ea9b-4e25-9a4f-321e11829929)
