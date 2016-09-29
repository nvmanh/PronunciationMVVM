package bluetapestudio.pronunciationmvvm.vn.libs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import bluetapestudio.pronunciationmvvm.vn.R;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 29/09/2016.
 */

public class ActivityControl {
    public static void startActivity(Activity activity, Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(activity, clazz);
        if (bundle == null) bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(activity, intent);
    }

    public static void startActivity(Activity activity, Intent intent) {
        startActivity(activity, intent, false, 0);
    }

    public static void startActivityForResult(Activity activity, Class<?> clazz, Bundle bundle,
                                              int requestCode) {
        Intent intent = new Intent(activity, clazz);
        if (bundle == null) bundle = new Bundle();
        intent.putExtras(bundle);
        startActivityForResult(activity, intent, requestCode);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        startActivity(activity, intent, true, requestCode);
    }

    private static void startActivity(Activity activity, Intent intent, boolean result, int requestCode) {
        if (result) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
        startAnimation(activity);
    }

    public static void startAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.hold, android.R.anim.fade_in);
    }

    public static void backAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.hold, android.R.anim.fade_out);
    }
}
