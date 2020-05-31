Feature: Register Gist

  Scenario: Create Public Gist Positif
    Given User Home Page Github
    When User want to create gist
    And have a filename TestGist.java
    And put Description sourcecode
    And Create Public Gist
    Then User sucessfully create public git

  Scenario: Edit Public Gist
    Given User Home Page Github
    When User want have see list gist
    And Have File TestGist
    And Edit File
    Then Update File Succesfully

  Scenario: Delete Public Gist
    Given User Home Page Github
    When User want have see list gist
    And Have File TestGist
    And Delete File
    Then Delete File Succesfully

  Scenario: See My List of Gist
    Given User Home Page Github
    When User want have see list gist
    Then List will showing


