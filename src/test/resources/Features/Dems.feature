@tag
Feature: Create a single trip in employee login
  

  @login
  Scenario Outline: Login with valid credential
    Given Open a chrome browser
    And Launch the DEMS website
    When I entered the valid username <Uname> and password <PW>
    Then Click on login button
    
    Examples:
    |Uname|PW|
    |"07246"|"Test@123"|
    
   @addtrip
   Scenario Outline: To add new trip
   Given Click on Add new button
   And Enter the Purpose <Purpose> of trip
   And Select the Start date and End Date
   And Enter the Description <Description>
   When Select the trip type
   Then Select from and To city
   And Select the travel mode <Travel_mode> and trip type <Trip_type>
   Then click on trip save button
   
   Examples:
   |Purpose|Description|Travel_mode|Trip_type|
   |"Client Meeting"|"Test"|"bus"|"overnight"|
   
   @edittrip
   Scenario Outline: To add new trip
   Given Click on Add new button
   And Enter the Purpose <Purpose> of trip
   And Select the Start date and End Date
   And Enter the Description <Description>
   When Select the trip type
   Then Select from and To city
   And Select the travel mode <Travel_mode> and trip type <Trip_type>
   Then click on trip save button
   
   Examples:
   |Purpose|Description|Travel_mode|Trip_type|
   |"Client Meeting"|"Test"|"bus"|"overnight"|
   
   @edittrip200
   Scenario Outline: To add new trip
   Given Click on Add new button
   And Enter the Purpose <Purpose> of trip+
   And Select the Start date and End Date
   And Enter the Description <Description>
   When Select the trip type
   Then Select from and To city
   And Select the travel mode <Travel_mode> and trip type <Trip_type>
   Then click on trip save button
   
   
   

   
   
   
   