package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import bluetapestudio.pronunciationmvvm.vn.model.Question;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public class ItemQuestionViewModel extends BaseObservable implements IViewModel {
    private Question question;
    private Context context;
    private static String TEXT_QUESTION = "Q. %d ";

    public ItemQuestionViewModel(Context context, Question question) {
        this.context = context;
        this.question = question;
    }

    @Override
    public void onDestroy() {

    }

    public String getContent() {
        return question.getContent();
    }

    public String getId() {
        return String.format(TEXT_QUESTION, question.getId());
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
