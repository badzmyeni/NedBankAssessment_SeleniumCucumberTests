Feature: Registration to Way2automation Website
  As a user i want to do a registration on the
  Way2automation website so that i can gain access on the website

  Scenario: Successful Registration
    Given User is on the Registration page
    When User enters random data entries for the requested fields that meet the required validation
    Then User clicks submit button
