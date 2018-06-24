package sg.howard.twitterclient.timeline;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import sg.howard.twitterclient.R;

public class TimelineActivity extends AppCompatActivity implements TimelineContract.View{
    RecyclerView rvTimeline;
    TimelineContract.Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        rvTimeline = findViewById(R.id.rvTimeline);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(TimelineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading(boolean isShow) {
    }

    @Override
    public void onGetStatusesSuccess(List<Tweet> data) {
        rvTimeline.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return data.;
            }
        });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
