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
    @tag4
    Scenario: Verify whether user is able to create Department
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on Department submodule
    And Click on Create icon button of Department
    And Enter All the data
    And Click on Add button of Department
    Then User should be able to view success message of created department
    @tag5
    Scenario: Verify whether user is able to import the valid file like xls and csv
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on Department submodule
    And Click on Import Icon button
    And Select the file from the System
    And Click on Import button 
    Then User should be able to view Succes and Error count message
    @tag6
    Scenario: Verify whether user is able to Edit the data in edit department page
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on Department submodule
    And Click on Edit icon button
    And Edit the data
    And Click on Save button
    Then User should be able to view success message of edit department
    @tag7
    Scenario: Verify whether user is able to delete the single records from department list page which is unmapped
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on Department submodule
    And Click on delete icon button
    And Click on Yes button
    Then User should be able to view success message of deleted records
    @tag8
    Scenario: Verify whether user is able to scroll the department list page and print all the records on console
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on Department submodule
    Then User should be able to Scroll the page and print all the records
    @tag9
    Scenario: Verify whether user is able to create position with valid data
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on position submodule
    And Click on create postion icon button
    And Enter the all the data in postion page
    And Click on Add button of postions
    Then User should be able to view the success message of created position
    @tag10
    Scenario: Verify whether us er is able to delete the postion
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    Then User should be able to view dashboard page
    And Click on cardholder module
    And Click on position submodule
    And Click on Position delete button
    And Click on delete button
    Then User should be able to view delete success message
    
    
    
   
   
   
    
    
  