package rezkyaulia.com.dattel_module1.data.Network;

import android.content.Context;
import rezkyaulia.com.dattel_module1.model.Repo;

import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

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
