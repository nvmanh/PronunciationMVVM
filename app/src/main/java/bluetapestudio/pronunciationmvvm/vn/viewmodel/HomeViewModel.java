package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import java.util.List;

import bluetapestudio.pronunciationmvvm.vn.App;
import bluetapestudio.pronunciationmvvm.vn.model.Question;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class HomeViewModel extends BaseViewModel {
    public ObservableField<String> questionContent;
    private Subscription subscription;
    private List<Question> questions;

    public HomeViewModel(Context context, ICallback callback) {
        super(context, callback);
        questionContent = new ObservableField<>();
        loadAllQuestions();
    }

    private void loadAllQuestions() {
        if (subscription != null && !subscription.isUnsubscribed()) subscription.unsubscribe();
        subscription = App.self().getInterviewApiService().fetchAllQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(App.self().defaultSubscribeScheduler())
                .subscribe(new Subscriber<List<Question>>() {
                    @Override
                    public void onCompleted() {
                        if (getCallback() != null) getCallback().onSuccess(getQuestions());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Question> questions) {
                        setQuestions(questions);
                    }
                });
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}