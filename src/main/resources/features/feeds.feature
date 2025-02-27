Feature: Add New Feeds , Bookmark

  Scenario Outline: Open Crispy Succotash Application
    Then I Navigate to Crispy Succotash Application "http://localhost:8000/"
    Then Click on Login Button
    And Enter user credentials "<Username>" "<Password>" to login
    Then Verify user is logged in succesfully

    Examples:
      | Username            | Password   |
      | manasa123@gmail.com | crispy@123 |

  Scenario Outline: Add a new feed item and verify in All feeds and My feed Tab
    Given Click on New Feed and add a feed url "<FeedUrl>"
    Examples:
      | FeedUrl |
      |  http://www.nu.nl/rss/Algemeen       |

  Scenario Outline: Validate Feed URL field is mandatory and check by adding existing url
    Given Click on New Feed and add a feed url "<FeedUrl>"
    Then Verify error message when feed url is empty "<FeedURLError>"
    Examples:
      | FeedUrl | FeedURLError|
      |         | EmptyFieldError |
    | http://www.nu.nl/rss/Algemeen|FeedExistingError|

  Scenario Outline: Add a multiple feed item and verify in All feeds and My feed Tab
    Given Click on New Feed and add a feed url "<FeedUrl>"
    Examples:
      | FeedUrl |
      |  http://www.nu.nl/rss/Algemeen       |
    |https://feeds.feedburner.com/tweakers/mixed|