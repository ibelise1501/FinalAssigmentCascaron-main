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

Feature: Active a Driver
  As a: GoHeavy Admin
  I Want To: activate a Driver
  So That: the Driver's status updates to GoHeavy Ready.

  Background:
    Given Any "GoHeavy Admin / Fleet Owner" is logged

    Scenario: Active a Driver
      Given A new "Driver" is created.
        And The Driver's documents are Approved.
        And A new "Vehicle" is created.
        And The Vehicle's documents are Approved.
        And The Vehicle has a Driver associated.
    When The User updates the Driver's status to "GoHeavy Ready".
      Then The Driver is active.

