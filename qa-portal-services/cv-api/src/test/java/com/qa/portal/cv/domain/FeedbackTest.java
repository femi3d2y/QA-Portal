package com.qa.portal.cv.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackTest {

    @InjectMocks
    public MockFeedbackList feedback = new MockFeedbackList();

    @Test
    public void getReviewerTest() {
        assertEquals("getReviewer() returning an unexpected result",
                "Tom Bennett",
                feedback.getFeedbackList().get(2).getReviewer());
    }

    @Test
    public void getDateTest() {
        assertEquals("getDate() returning an unexpected result",
                "2011-06-31",
                feedback.getFeedbackList().get(2).getDate());
    }

    @Test
    public void getComment() {
        assertEquals("getComment() returning an unexpected result",
                "feedback 3",
                feedback.getFeedbackList().get(2).getComment());
    }
}