package bluetapestudio.pronunciationmvvm.vn.view;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import bluetapestudio.pronunciationmvvm.vn.R;
import bluetapestudio.pronunciationmvvm.vn.databinding.ItemQuestionBinding;
import bluetapestudio.pronunciationmvvm.vn.model.Question;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.ItemQuestionViewModel;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.QuestionViewHolder> {

    private List<Question> questions;
    private View.OnClickListener onClickListener;

    public RepositoryAdapter() {
        this.questions = Collections.emptyList();
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemQuestionBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_question,
                parent,
                false);
        return new QuestionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        holder.bindQuestion(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        final ItemQuestionBinding binding;

        public QuestionViewHolder(final ItemQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getOnClickListener() != null)
                        getOnClickListener().onClick(binding.getRoot());
                }
            });
        }

        void bindQuestion(Question question) {
            binding.getRoot().setTag(question);
            if (binding.getQuestionModel() == null) {
                binding.setQuestionModel(new ItemQuestionViewModel(itemView.getContext(),
                        question));
            } else {
                binding.getQuestionModel().setQuestion(question);
            }
        }
    }
}
