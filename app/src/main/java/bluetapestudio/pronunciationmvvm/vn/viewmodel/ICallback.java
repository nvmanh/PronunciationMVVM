package bluetapestudio.pronunciationmvvm.vn.viewmodel;

import java.util.List;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public interface ICallback<T> {
    void onSuccess(List<T> data);
}
