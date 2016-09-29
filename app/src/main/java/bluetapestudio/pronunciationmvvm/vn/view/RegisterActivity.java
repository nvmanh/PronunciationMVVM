package bluetapestudio.pronunciationmvvm.vn.view;

import bluetapestudio.pronunciationmvvm.vn.R;
import bluetapestudio.pronunciationmvvm.vn.databinding.ActivityRegisterBinding;
import bluetapestudio.pronunciationmvvm.vn.model.User;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.BaseViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.LoginViewModel;
import rx.Subscriber;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 29/09/2016.
 */

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {
    public LoginViewModel loginViewModel;

    @Override
    public BaseViewModel getViewModel() {
        return loginViewModel;
    }

    @Override
    protected void initView() {
        loginViewModel = new LoginViewModel(this);
        getViewDataBinding().setLoginModel(loginViewModel);
        loginViewModel.addSubscriber(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }
}