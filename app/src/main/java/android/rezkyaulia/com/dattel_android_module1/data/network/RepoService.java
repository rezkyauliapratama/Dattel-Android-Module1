package android.rezkyaulia.com.dattel_android_module1.data.network;

import android.content.Context;
import android.rezkyaulia.com.dattel_android_module1.data.Repo;

import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import timber.log.Timber;

/**
 * Created by Rezky Aulia Pratama on 5/7/2018.
 */

public class RepoService {

    private String url_path = "orgs/Google/repos";

    public RepoService() {

    }

    public void getRepos(Context context, FutureCallback<Repo[]> callback){

        String final_url = API.URL_BASE.concat(url_path);

        Timber.e("final URL : ".concat(final_url));

        Atom.with(context)
                .load(final_url)
                .as(Repo[].class)
                .setCallback(callback);
    }
}
