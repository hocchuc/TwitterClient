package sg.howard.twitterclient;

import android.app.Application;

import com.facebook.stetho.Stetho;

import sg.howard.twitterclient.util.SharedPreferenceHelper;

public class TwitterClientApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this).build());
        SharedPreferenceHelper.getInstance().setContext(this);

    }
}
