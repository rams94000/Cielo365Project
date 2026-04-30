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
    
    @tag5
    Scenario: Create cardholder with all mandatory fields after successful login
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on cardholder submodule
    And Click on cardholder add icon button
    And Enter all data in mandatory fields for cardholder
    And Click on cardholder add button
    Then Cardholder should be created successfully
    
    @tag6
    Scenario: Create cardholder with non mandatory fields
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on cardholder submodule
    And Click on cardholder add icon button
    And Enter all data in non mandatory fields for cardholder
    And Click on cardholder add button
    Then the user should see a mandatory field error message for cardholder
    
    @tag7
    Scenario: Delete cardholder having mapped records
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on cardholder submodule
    And Click On Delete button of cardholder page
    Then the user should be able to see cardholder delete success message
    
    @tag8
    Scenario: Edit cardholder details
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on cardholder submodule
    And Click on edit button of cardholder
    And Edit the data
    Then the user should be able to view success message of edit cardholder
    
    @tag9
    Scenario: View all records on the console
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on cardholder submodule
    Then Scroll the cardholder page
    
    @tag10
    Scenario: Create Department with mandatory fields
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on Departments submodule
    And Click on Add icon buttton of department list page
    And Enter all mandatory fields in department create page
    And Click on Add button in department create page
    Then the user should be able to view department created successfully message
    
    @tag11
    Scenario: Edit the Departments data
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on cardholder module
    And Click on Departments submodule
    And Click On Departments edit button
    And Edit the data of Departments
    And Click on edit button of departments
    Then the user should be able to view Department edited successfully
    
    @tag12
    Scenario: Verify user is able to update the profile
    Given Enter the URL
    When Enter username and password
    And Click on privacy checkbox
    And Click on Signin button
    And Click on drop down and select the value
    And Click on Enter button
    And Click on profile icon button
    And Click on my profile
    And Edit the data of profile
    And Click on Save button of profile
    Then User should be able to view profile updated successfully
   
    
    
    
    
    
    
    
    #Scenario Outline: Create cardholder with different mandatory data
  #Given the user is logged into the application
  #When the user enters "<FirstName>" "<LastName>" "<Department>"
  #And clicks on create
  #Then the cardholder should be created successfully
#
#Examples:
#| FirstName | LastName | Department |
#| John      | Smith    | Finance    |
#| David     | Lee      | HR         |
#| Maria     | Lopez    | IT         |
    #
    #
    #
    
  