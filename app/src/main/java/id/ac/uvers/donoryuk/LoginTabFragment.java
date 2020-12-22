package id.ac.uvers.donoryuk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import id.ac.uvers.donoryuk.models.UserResponse;
import id.ac.uvers.donoryuk.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginTabFragment extends Fragment implements View.OnClickListener {

    private EditText textUsername;
    private EditText textPassword;
    private Button btnLogin;

    private final ApiService service = new ApiService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.login_fragment, container, false);
        textUsername = view.findViewById(R.id.edit_username);
        textPassword = view.findViewById(R.id.edit_password);
        btnLogin = view.findViewById(R.id.btn_login);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            login(String.valueOf(textUsername.getText()), String.valueOf(textPassword.getText()));
        }
    }

    private void login(String username, String password) {
        Call<UserResponse> userCall = service.getService().login(username, password);
        userCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Intent intent = new Intent(getContext(), ReqDarahActivity.class);
                    SessionPreference session = new SessionPreference(Objects.requireNonNull(getContext()));
                    session.setUser(response.body().getUser());
                    Objects.requireNonNull(getContext()).startActivity(intent);
                } else {
                    Log.d("data", "gagal");
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                Log.d("data", "gagal");
            }
        });
    }

}
