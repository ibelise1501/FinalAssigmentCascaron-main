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

Feature: Edit Driver 2.2
  As a: GoHeavy Admin / Fleet Owner/ Document Approver
  I Want To: edit the personal information of a Driver
  So That: I can update the Driver's data allowed for the role and his Status.


      #TODO
  Scenario: Edit Driver 2.2 ----- Inserts valid data AND clicks on the "Update" button.
    Given  Any "GoHeavy Admin / Document Approver" is logged
    And  The user is in "Drivers List" view.
    When User clicks on the "Edit" icon.
    And  The System displays the "Edit Driver" view with the data preloaded.
    And  The User set the Status to "GoHeavy Ready".
    And  The User clicks on the "Update" button.
    Then The user is in "Drivers List" view.
    And  The system updates the status to "GoHeavy Ready".