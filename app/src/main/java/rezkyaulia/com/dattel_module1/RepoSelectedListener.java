package rezkyaulia.com.dattel_module1;


import rezkyaulia.com.dattel_module1.model.Repo;

/**
 * Created by Rezky Aulia Pratama on 3/1/2018.
 */

public interface RepoSelectedListener {
    void onRepoSelected(Repo repo);
    void onErrorListener();
    void onLoadingListener();
    void onSuccesfullListener();
}
