package rezkyaulia.com.dattel_module1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rezkyaulia.com.dattel_module1.model.Repo;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.screen_container, new ListFragment())
                    .commit();
        }
    }

    @Override
    public void onDetailsInteraction(Repo repo) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(DetailsFragment.ARG_PARAM1, repo);
        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screen_container, fragment)
                .commit();
    }
}
