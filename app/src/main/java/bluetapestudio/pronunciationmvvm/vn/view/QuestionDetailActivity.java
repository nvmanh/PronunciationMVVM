package bluetapestudio.pronunciationmvvm.vn.view;

import bluetapestudio.pronunciationmvvm.vn.R;
import bluetapestudio.pronunciationmvvm.vn.databinding.ActivityQuestionDetailBinding;
import bluetapestudio.pronunciationmvvm.vn.model.Question;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.BaseViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.QuestionDetailModel;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 28/09/2016.
 */

public class QuestionDetailActivity extends BaseActivity<ActivityQuestionDetailBinding> {
    private QuestionDetailModel questionDetailModel;

    @Override
    public BaseViewModel getViewModel() {
        return questionDetailModel;
    }

    @Override
    protected void initView() {
        Question question = (Question) getIntent().getExtras().getSerializable("data");
        questionDetailModel = new QuestionDetailModel(this, question);
        getViewDataBinding().setQuestionModel(questionDetailModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_question_detail;
    }
}
