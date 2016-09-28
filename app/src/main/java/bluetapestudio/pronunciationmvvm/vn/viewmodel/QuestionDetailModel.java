package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import bluetapestudio.pronunciationmvvm.vn.model.Question;
import bluetapestudio.pronunciationmvvm.vn.R;
/**
 * Created by FRAMGIA\nguyen.viet.manh on 28/09/2016.
 */

public class QuestionDetailModel extends BaseViewModel {
    public final ObservableField<String> questionId;
    public final ObservableField<String> questionContent;
    private Question question;

    public QuestionDetailModel(Context context, Question question) {
        super(context);
        questionId = new ObservableField<>();
        questionContent = new ObservableField<>();
        updateQuestion(question);
    }

    /**
     * can update from other fragment
     *
     * @param question
     */
    public void updateQuestion(Question question) {
        this.question = question;
        setFieldData();
    }

    public void setFieldData() {
        questionId.set(String.format(getContext().getString(R.string.question_id),
                String.valueOf(question.getId())));
        questionContent.set(question.getContent());
    }
}
