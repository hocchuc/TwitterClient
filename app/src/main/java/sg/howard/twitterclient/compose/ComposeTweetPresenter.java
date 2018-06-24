package sg.howard.twitterclient.compose;

import androidx.annotation.NonNull;


public class ComposeTweetPresenter implements ComposeContract.Presenter {

    private final ComposeContract.View view;

    public ComposeTweetPresenter(@NonNull ComposeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
