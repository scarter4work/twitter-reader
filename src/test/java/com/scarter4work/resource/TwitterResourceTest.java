package com.scarter4work.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TwitterResourceTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() {
        List<Tweet> tweets = this.restTemplate.getForObject("/fetchTweets", List.class);
        Assert.assertEquals(tweets.size(), 10);
    }
}