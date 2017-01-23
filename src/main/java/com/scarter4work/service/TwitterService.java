package com.scarter4work.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource(value = "classpath:service.properties")
public class TwitterService {
    private static Logger logger = Logger.getLogger(TwitterService.class);

    @Value("${twitter.user.timeline:@salesforce}")
    private String userTimeline;

    @Value("${twitter.results.size:10}")
    private Integer resultsSize;

    @Autowired
    private Twitter twitter;

    /**
     * Returns the tweets that are part of the user specified by the feedName
     * as a list of tweets.
     * @return List<Tweet>
     * @throws Exception
     */
    public List<Tweet> getSalesforceTweets() throws Exception {
        logger.debug("getSalesforceTweets() entering.");
        List<Tweet> tweets = this.twitter.timelineOperations().getUserTimeline(userTimeline, resultsSize);
        logger.debug("getSalesforceTweets() number of tweets retreived: " + tweets.size());
        logger.debug("getSalesforceTweets() exiting.");
        return tweets;
    }
}