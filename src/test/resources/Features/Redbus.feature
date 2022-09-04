@redbus
Feature: Redbus

 
  Scenario: Seat Selection_CHROME
    Given Launch Redbus Application
    When Select Currency Type
    Then Search Bus
    Then Validate Departure Time Sorted in DescendingOrder
    Then View Seats

  Scenario: Seat Selection_EDGE
    Given Launch Redbus Application
    When Select Currency Type
    Then Search Bus
    Then Validate Departure Time Sorted in DescendingOrder
    Then View Seats
