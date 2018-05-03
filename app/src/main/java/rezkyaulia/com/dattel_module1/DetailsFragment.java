package rezkyaulia.com.dattel_module1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rezkyaulia.com.dattel_module1.model.Repo;

/**
 * Created by Rezky Aulia Pratama on 5/3/2018.
 */

public class DetailsFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";


    @BindView(R.id.tv_forks)
    TextView forksTextView;
    @BindView(R.id.tv_repo_description)
    TextView repoDescriptionTextView;
    @BindView(R.id.tv_repo_name)
    TextView repoNameTextView;
    @BindView(R.id.tv_stars)
    TextView starsTextView;

    private Unbinder unbinder;
    private Repo repo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            repo = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_details, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (repo != null){
            repoNameTextView.setText(repo.name);
            repoDescriptionTextView.setText(repo.description);
            forksTextView.setText(String.valueOf(repo.forks));
            starsTextView.setText(String.valueOf(repo.stars));
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null){
            unbinder.unbind();
            unbinder = null;
        }
    }

}
