#Given: Some precondition step
#------------------------------------------
#1. The GoHeavy Admin / Fleet Owner must be logged in the system.
#2. The GoHeavy Admin / Fleet Owner is on the "Vehicles & Insurance List" view.
#------------------------------------------
#When: Some key actions
#Then: To observe outcomes or validation
#------------------------------------------
#1. Clicks on the "Add Vehicle" button.
#------------------------------------------
#And,But:
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: Given Any user is logged
#Sample Feature Definition Template

Feature: Add Driver 2.3
  As a: GoHeavy Admin / Fleet Owner
  I Want To: add a Driver
  So That: a new Driver is registered in the system.

  Background:
    Given Any "GoHeavy Admin / Fleet Owner" is logged
      And The user is in "Drivers List" view.

    Scenario: Add Driver 2.3 -- Add Driver

    When User clicks on "Add Driver" button.
      And The system opens the "Add Driver" view.
      And The user inserts a valid data
      And User clicks on the Add button.
    Then The System displays message "A new Driver was successfully created."
      And System returns to the "Drivers List" view
  #TODO
      #And The System Creates a new Driver in "On-boarding" status.
      #And The default rating is 4 points
      #And System registers the creation date.

