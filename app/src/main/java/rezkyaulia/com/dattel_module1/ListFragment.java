package rezkyaulia.com.dattel_module1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import rezkyaulia.com.dattel_module1.model.Repo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Rezky Aulia Pratama on 5/3/2018.
 */

public class ListFragment extends Fragment implements RepoSelectedListener {

    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView listView;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @BindView(R.id.loading_view) View loadingView;

    OnFragmentInteractionListener mListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        listView.setAdapter(new RepoListAdapter(getContext(), this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onRepoSelected(Repo repo) {
        mListener.onDetailsInteraction(repo);
    }

    @Override
    public void onErrorListener() {
            errorTextView.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            errorTextView.setText(R.string.api_error_repos);

    }

    @Override
    public void onLoadingListener() {
        loadingView.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void onSuccesfullListener() {
        errorTextView.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        errorTextView.setText(null);
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDetailsInteraction(Repo repo);

    }
}
