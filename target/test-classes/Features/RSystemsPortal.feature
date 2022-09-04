Feature: RSystemsPortal

  @chrome
  Scenario: Cancel WFH Request_Chrome
    Given User launch RSystems application
    When Verify user logged successfully
    And Navigate to Work From Home Request module
    And Create WFH request
    And Navigate to WFH Cancellation Tab
    Then Verify WFH Request created

  @edge
  Scenario: Cancel WFH Request_Edge
    Given User launch RSystems application
    When Verify user logged successfully
    And Navigate to Work From Home Request module
    And Create WFH request
    And Navigate to WFH Cancellation Tab
    Then Verify WFH Request created
