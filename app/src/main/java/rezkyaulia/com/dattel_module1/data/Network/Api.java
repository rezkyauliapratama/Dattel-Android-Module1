package rezkyaulia.com.dattel_module1.data.Network;

import android.content.Context;

/**
 * Created by Rezky Aulia Pratama on 5/3/2018.
 */

public class Api {
    public static final String BASE_URL = "https://api.github.com/";
    RepoService repoService;

    public Api(Context context) {
        this.repoService = new RepoService(context);
    }

    public RepoService getRepoService() {
        return repoService;
    }
}
