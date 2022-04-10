#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Customer navigation through product category

Scenario: Navigate through product category
Given I am on DEMO webpage
When I click navigate through "Phones" category
Then Check for an specific product "Sony vaio i7" in selected category

Scenario: Navigate through Monitors category
Given I am on DEMO webpage
When I click navigate through Monitors category
Then Check for monitor "Apple monitor 24" is selected category