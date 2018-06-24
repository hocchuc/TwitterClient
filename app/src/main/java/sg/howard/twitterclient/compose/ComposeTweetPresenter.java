package sg.howard.twitterclient.compose;

import androidx.annotation.NonNull;
import sg.howard.twitterclient.base.BaseView;


public class ComposeTweetPresenter implements ComposeContract.Presenter {

    private final ComposeContract.View mView;

    public ComposeTweetPresenter(@NonNull ComposeContract.View  view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
