package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import android.content.Context;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public abstract class BaseViewModel implements IViewModel {
    private Context context;
    private ICallback callback;

    public BaseViewModel(Context context, ICallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public BaseViewModel(Context context) {
        this(context, null);
    }
    public Context getContext() {
        return context;
    }

    public ICallback getCallback() {
        return callback;
    }

    @Override
    public void onDestroy() {
        callback = null;
    }
}
