package bluetapestudio.pronunciationmvvm.vn;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bluetapestudio.pronunciationmvvm.vn.model.InterviewApiService;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class App extends Application {
    private static App _self;
    private Gson gson;
    private Scheduler defaultSubscribeScheduler;
    private InterviewApiService interviewApiService;

    public static App self() {
        return _self;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _self = this;
    }

    public Gson gson() {
        if (gson == null) gson = new GsonBuilder().serializeNulls().create();
        return gson;
    }

    public InterviewApiService getInterviewApiService() {
        if (interviewApiService == null)
            interviewApiService = InterviewApiService.InterviewFactory.create();
        return interviewApiService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
