Feature: Test ToolsQA
Scenario: Test practice windows handling
 Given Launch browser
 When Goto DemoSites
 Then Select practice swich windows
 Then Click on New Browser Window 6 times
 Then Click on New Message Window
 Then Validate message
 |message|
 |Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.|