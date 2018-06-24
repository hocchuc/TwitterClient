package sg.howard.twitterclient.api;

import java.util.List;

import sg.howard.twitterclient.model.TimelineItem;
import sg.howard.twitterclient.model.User;

public interface TwitterService {

    List<TimelineItem> getTimelineItems();

    User getMyDetails();

    Boolean sendTweet(String tweetText);

    User getCurrentUser();

    void setCurrentUser(User user);
}
