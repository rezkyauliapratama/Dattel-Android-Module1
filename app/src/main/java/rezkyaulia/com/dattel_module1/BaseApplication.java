package rezkyaulia.com.dattel_module1;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * Created by Rezky Aulia Pratama on 3/2/2018.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }


}
