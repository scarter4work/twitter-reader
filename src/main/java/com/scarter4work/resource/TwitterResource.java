package com.scarter4work.resource;

import com.scarter4work.service.TwitterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwitterResource {
    /** logger instance */
    private static Logger logger = Logger.getLogger(TwitterResource.class);

    /** twitter service reference */
    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value="/fetchTweets", method = RequestMethod.GET)
    public @ResponseBody List<Tweet> fetchSalesforceTweets() throws Exception {
        logger.debug("fetchSalesforceTweets() entering.");
        List<Tweet> tweets = this.twitterService.getSalesforceTweets();
        tweets.forEach(tweet -> {
            logger.info("Tweet received: " + tweet.toString());
        });
        logger.debug("fetchSalesforceTweets() exiting.");
        return tweets;
    }
}