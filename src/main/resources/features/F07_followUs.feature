@smoke
  Feature: FollowUsFeature | when user click on social media icon is redirected to social media link
    Scenario: user clicks facebook icon
      When user clicks facebook icon
      Then facebook link is opened in new tab

    Scenario: user clicks twitter icon
      When user clicks twitter icon
      Then twitter link is opened in new tab

    Scenario: user clicks rss icon
      When user clicks rss icon
      Then rss link is opened in new tab

    Scenario: user clicks youtube icon
      When user clicks youtube icon
      Then youtube link is opened in new tab

