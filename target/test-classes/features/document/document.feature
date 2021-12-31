

Feature: View Driver/Vehicle Documents
  As a: GoHeavy Admin / Document Approver / Fleet Owner
  I Want To: to view a selected driver/vehicle document
  So That: I can Approve OR Consider a document.

   Scenario Outline: Approve the "Documents"
    Given Any "GoHeavy Admin / Document Approver / Fleet Owner" is logged
      And The user is in "<ListView>" view.
    When  User clicks on the "Documents" icon
      And The system displays the "<DocumentsView>" view.
      And User clicks on "View" icon.
      And The system displays the "<ModalViewName>" view.
      And The User clicks on the "Approve" button.
     Then The system changes the Driver's/Vehicle's document status to "Clear"

    Examples:
      | ListView                  | DocumentsView                  | ModalViewName                                           |
      | Drivers List              | Documents for <Driver's name>  | Driver's name - <Document Type>                         |
      | Vehicles & Insurance List | Documents for <Vehicle's VIN>  | Vehicle's VIN - Vehicle Identification Number (VIN)     |
