package id.ac.uvers.donoryuk;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.uvers.donoryuk.adapters.DarahAdapter;
import id.ac.uvers.donoryuk.models.UsersResponse;
import id.ac.uvers.donoryuk.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReqDarahActivity extends AppCompatActivity {

    private final ApiService service = new ApiService();
    private DarahAdapter adapter;

    private RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_darah);

        adapter = new DarahAdapter();
        fetch();

        rvUsers = findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(true);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        rvUsers.setAdapter(adapter);
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