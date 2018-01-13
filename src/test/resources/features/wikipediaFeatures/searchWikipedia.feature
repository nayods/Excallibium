Feature: search Wikipedia

  Background:
    Given Open http://en.wikipedia.org
    And Do login

  Scenario: direct search article
    Given Enter search term 'Cucumber'
    When Do search
    Then Single result is shown for 'Cucumber'

  Scenario Outline:
    Given Enter search term '<searchTerm>'
    When I click the submit button
    Then Multiple results are shown for '<result>'

    Examples:
      | searchTerm | result                |
      | mercury    | Mercury may refer to: |
      | max        | Max may refer to:     |