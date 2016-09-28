package bluetapestudio.pronunciationmvvm.vn.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import bluetapestudio.pronunciationmvvm.vn.viewmodel.BaseViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.IViewModel;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity
        implements IViewModel {
    private T viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getViewModel() != null) getViewModel().onDestroy();
    }

    public abstract BaseViewModel getViewModel();

    protected T getViewDataBinding() {
        return viewDataBinding;
    }

    protected abstract void initView();

    protected abstract int getLayoutId();
}