package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.List;

import bluetapestudio.pronunciationmvvm.vn.App;
import bluetapestudio.pronunciationmvvm.vn.model.Question;
import bluetapestudio.pronunciationmvvm.vn.model.User;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 29/09/2016.
 */

public class LoginViewModel extends BaseViewModel {

    public final ObservableField<String> account;
    public final ObservableField<String> password;
    public final ObservableBoolean remember;
    private Subscription subscription;
    public LoginViewModel(Context context) {
        super(context);
        account = new ObservableField<>();
        password = new ObservableField<>();
        remember = new ObservableBoolean();
    }

    public void addUser(User user) {
        if (user.isNewUser()) {
            registerUser(user);
        } else {
            login(user);
        }
    }

    public void addSubscriber(Subscriber<User> subscriber) {
        this.subscriber = subscriber;
    }

    private void reset() {
        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();
    }

    private Subscriber<User> subscriber = new Subscriber<User>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(User user) {

        }
    };

    private void login(User user) {
        reset();
        subscription = App.self().getInterviewApiService().register(user.getUserName(),
                user.getPassword(), user.getEmail(), user.getPhone())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(App.self().defaultSubscribeScheduler())
                .subscribe(subscriber);
    }

    private void registerUser(User user) {
        reset();
        subscription = App.self().getInterviewApiService().login(user.getUserName(),
                user.getPassword())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(App.self().defaultSubscribeScheduler())
                .subscribe(subscriber);
    }
}