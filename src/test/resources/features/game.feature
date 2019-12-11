Feature: BoardGameGeek service

#  Step 1: WEB Open homepage of the site
#  Step 2: WEB Navigate to the page of the game with highest rank in "The Hotness" left side menu
#  Step 3: API Retrieve information about a particular game from site api
#  Step 4: API Parse response to get most voted option in Language Dependence poll
#  Step 5: WEB Assert Language Dependence text presented in the game page Description block equals the most
#  voted Language Dependence level.

  @baseTest
  Scenario: Language Dependence field description validation
    Given I open homepage of the web site
    When Navigate to the page of the game with highest rank in "The Hotness" left side menu
    Then I select "Game" option
    And I open highest rank game
    Then I collect information about game with highest rank from web page
    And I retrieve information about a particular game from site api
    When I parse response to get most voted option in "Language Dependence" poll
    Then I assert Language Dependence text on the page and retrieved information from API side

