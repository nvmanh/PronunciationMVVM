package bluetapestudio.pronunciationmvvm.vn.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bluetapestudio.pronunciationmvvm.vn.R;
import bluetapestudio.pronunciationmvvm.vn.databinding.ActivityHomeBinding;
import bluetapestudio.pronunciationmvvm.vn.model.Question;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.BaseViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.HomeViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.ICallback;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> implements ICallback<Question> {
    private HomeViewModel homeViewModel;

    @Override
    public BaseViewModel getViewModel() {
        return homeViewModel;
    }

    @Override
    protected void initView() {
        homeViewModel = new HomeViewModel(this, this);
        getViewDataBinding().setQuestionModel(homeViewModel);
        setupRecyclerView(getViewDataBinding().questionRecyclerView);
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        RepositoryAdapter adapter = new RepositoryAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == null || view.getTag() == null) return;
                Question question = (Question) view.getTag();
                showDetailQuestionActivity(question);
            }
        });
    }

    private void showDetailQuestionActivity(Question question) {
        Intent intent = new Intent(this, QuestionDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", question);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onSuccess(List<Question> data) {
        if (data == null || data.isEmpty()) data = new ArrayList<>();
        RepositoryAdapter adapter =
                (RepositoryAdapter) getViewDataBinding().questionRecyclerView.getAdapter();
        adapter.setQuestions(data);
        adapter.notifyDataSetChanged();
    }
}
