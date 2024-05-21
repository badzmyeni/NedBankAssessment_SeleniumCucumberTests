# Way2Automation Registration Test Project

## Overview

This project automates the registration process on the Way2Automation website using Selenium WebDriver and Cucumber for BDD (Behavior-Driven Development). The project is structured to allow easy management and scalability of test cases.

## Project Structure

The project consists of the following main components:

1. **Feature File**: Defines the behavior of the registration process in a natural language format.
2. **Page Object Model**: Encapsulates the WebElements and actions for the registration page.
3. **Step Definitions**: Maps the steps from the feature file to the actual Selenium code.
4. **Test Runner**: Configures and runs the Cucumber tests.
5. **pom.xml**: Manages project dependencies and configurations using Maven.

## Feature File

The feature file describes the scenario for a successful registration on the Way2Automation website.

```gherkin
Feature: Registration to Way2automation Website
  As a user I want to do a registration on the Way2automation website so that I can gain access to the website

  Scenario: Successful Registration
    Given User is on the Registration page
    When User enters random data entries for the requested fields that meet the required validation
    Then User clicks submit button
