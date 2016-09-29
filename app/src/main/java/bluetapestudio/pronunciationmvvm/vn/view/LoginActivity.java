package bluetapestudio.pronunciationmvvm.vn.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import bluetapestudio.pronunciationmvvm.vn.R;
import bluetapestudio.pronunciationmvvm.vn.databinding.AcitivityLoginBinding;
import bluetapestudio.pronunciationmvvm.vn.libs.ActivityControl;
import bluetapestudio.pronunciationmvvm.vn.model.User;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.BaseViewModel;
import bluetapestudio.pronunciationmvvm.vn.viewmodel.LoginViewModel;
import rx.Subscriber;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 29/09/2016.
 */

public class LoginActivity extends BaseActivity<AcitivityLoginBinding> {
    private LoginViewModel loginViewModel;

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
        return R.layout.acitivity_login;
    }

    public void onForgotPassword(View view) {
    }

    public void onLogin(View v) {
        if (true) {
            ActivityControl.startActivity(this, HomeActivity.class, null);
            return;
        }
        User user = new User(getViewDataBinding().edtName.getText().toString().trim(),
                getViewDataBinding().edtPassword.getText().toString().trim());
        if (TextUtils.isEmpty(user.getUserName())) {
            getViewDataBinding().edtName.setError("Your name is blank");
        } else if (TextUtils.isEmpty(user.getPassword())) {
            getViewDataBinding().edtPassword.setError("Your password is blank");
        } else {
            loginViewModel.addUser(user);
        }
    }

    public void onRegister(View v) {
        ActivityControl.startActivity(this, RegisterActivity.class, null);
    }
}
