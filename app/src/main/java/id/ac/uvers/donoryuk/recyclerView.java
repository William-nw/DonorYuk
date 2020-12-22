package id.ac.uvers.donoryuk;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.uvers.donoryuk.adapters.DarahAdapter;
import id.ac.uvers.donoryuk.models.UsersResponse;
import id.ac.uvers.donoryuk.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class recyclerView extends Fragment {

    private final ApiService service = new ApiService();
    private DarahAdapter adapter;

    private RecyclerView rvUsers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new DarahAdapter();
        fetch();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        rvUsers = view.findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(true);
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        rvUsers.setAdapter(adapter);
        return view;
    }

    private void fetch() {
        Call<UsersResponse> userCall = service.getService().fetch();
        userCall.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(@NonNull Call<UsersResponse> call, @NonNull Response<UsersResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setUsers(response.body().getUsers());
                } else {
                    Log.d("data", "gagal");
                }
            }

            @Override
            public void onFailure(@NonNull Call<UsersResponse> call, @NonNull Throwable t) {
                Log.d("data", "gagal");
            }
        });
    }
}