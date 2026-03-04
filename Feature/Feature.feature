@tag
Feature: Functional Testing

  @tag1
  Scenario: Verify whether user is able to login the application with valid credentials
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
   @tag2
   Scenario: Verify whether user is able to login the application with invalid username and invalid password
    Given Enter the URL
    When Enter invalid username and invalid password
    And Click on privacy checkbox
    And Click on Signin button
    Then User should be able to view error message invalid credentials for invalid password
    
    
    
    @tag3
    Scenario: Verify whether user is able to login the application with invalid username but valid password
    Given Enter the URL
    When Enter invalid username and valid password
    And Click on privacy checkbox
    And Click on Signin button
    Then User should be able to view error message invalid credentials for valid password
    
    @tag4
    Scenario: Verify whether user is able to login the application with valid username but invalid password
    Given Enter the URL
    When Enter valid username and invalid password
    And Click on privacy checkbox
    And Click on Signin button
    Then User should be able to view error message Invalid credentials The user account will be locked after two failed attempts
    
    
    
    
  