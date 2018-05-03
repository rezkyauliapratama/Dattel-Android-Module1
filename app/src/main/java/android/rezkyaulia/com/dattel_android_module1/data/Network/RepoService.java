package android.rezkyaulia.com.dattel_android_module1.data.Network;

import android.content.Context;
import android.rezkyaulia.com.dattel_android_module1.model.Repo;
import android.support.v4.content.ContextCompat;

import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import java.util.List;

/**
 * Created by Rezky Aulia Pratama on 5/3/2018.
 */

public class RepoService {
    Context context;

    RepoService(Context context) {
        this.context = context;
    }

    public void get(FutureCallback<Repo[]> callback){
        Atom.with(context)
                .load(Api.BASE_URL+"orgs/Google/repos")
                .as(Repo[].class)
                .setCallback(callback);
    }

    public void get(String owner, String name,FutureCallback<Repo> callback){
        Atom.with(context)
                .load(Api.BASE_URL+"repos/"+owner+"/"+name)
                .as(Repo.class)
                .setCallback(callback);
    }

}
