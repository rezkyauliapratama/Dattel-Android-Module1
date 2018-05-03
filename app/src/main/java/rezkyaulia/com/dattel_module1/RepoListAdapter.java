package rezkyaulia.com.dattel_module1;

import android.content.Context;
import rezkyaulia.com.dattel_module1.data.Network.Api;
import rezkyaulia.com.dattel_module1.model.Repo;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.infideap.atomic.FutureCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Rezky Aulia Pratama on 5/3/2018.
 */

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>{

    private final List<Repo> data = new ArrayList<>();
    private RepoSelectedListener repoSelectedListener;

    RepoListAdapter(Context context, RepoSelectedListener repoSelectedListener){
        this.repoSelectedListener = repoSelectedListener;

        repoSelectedListener.onLoadingListener();

        Api api = new Api(context);
        api.getRepoService().get(new FutureCallback<Repo[]>() {
            @Override
            public void onCompleted(Exception e, Repo[] result) {
                if (e != null){
                    Timber.e("OnError : ".concat(new Gson().toJson(e)));
                    repoSelectedListener.onErrorListener();
                }

                data.clear();

                if (result != null){
                    data.addAll(Arrays.asList(result));
                    notifyDataSetChanged();
                }

                repoSelectedListener.onSuccesfullListener();

            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repo_list_item,parent,false);
        return new RepoViewHolder(view,repoSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_repo_name)TextView repoNameTextView;
        @BindView(R.id.tv_repo_description)TextView repoDescriptionTextView;
        @BindView(R.id.tv_forks)TextView forksTextView;
        @BindView(R.id.tv_stars)TextView starsTextView;

        private Repo repo;
        RepoViewHolder(View itemView, RepoSelectedListener repoSelectedListener){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(Repo repo){
            this.repo = repo;
            repoNameTextView.setText(repo.name);
            repoDescriptionTextView.setText(repo.description);
            forksTextView.setText(String.valueOf(repo.forks));
            starsTextView.setText(String.valueOf(repo.stars));
        }
    }
}