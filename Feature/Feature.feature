#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
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
    Scenario: Verify whether after login the application user is able to perform click operation in cardholder module
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on cardholder submodule
    Then User should be able to view all records of cardholders on console
    @tag3
    Scenario: Verify whether user is able to create carholder by entering valid data
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on cardholder submodule
    And Click on create icon button
    And Enter all the information of cardholders
    And Click on Add button
    Then User should be able to view success message
    
    
    
    
    
    
    
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
  #  Given I want to write a step with <name>
  #  When I check for the <value> in step
  #  Then I verify the <status> in step

  #  Examples: 
  #    | name  | value | status  |
  #    | name1 |     5 | success |
  #    | name2 |     7 | Fail    |
