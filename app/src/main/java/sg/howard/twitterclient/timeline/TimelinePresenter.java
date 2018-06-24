package sg.howard.twitterclient.timeline;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import androidx.annotation.NonNull;
import sg.howard.twitterclient.api.TwitterService;
import sg.howard.twitterclient.base.BasePresenter;

public class TimelinePresenter implements TimelineContract.Presenter {
    TwitterApiClient client = null;
    TimelineContract.View view;
    public void TimelinePresenter(@NonNull TimelineContract.View view, TwitterSession session){
        this.view = view;
        view.setPresenter(this);
        client = new TwitterApiClient(session);

    }

    @Override
    public void start() {
        view.showLoading(true);
        client.getStatusesService()
                .homeTimeline(null, null, null, null, null, null, null)
                .enqueue(new Callback<List<Tweet>>() {
                    @Override
                    public void success(Result<List<Tweet>> result) {
                        view.showLoading(false);
                        view.onGetStatusesSuccess(result.data);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        view.showLoading(false);
                        view.showError(exception.getMessage());
                    }
                });
    }
}
