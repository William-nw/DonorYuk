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

public class RegisterTabFragment extends Fragment implements View.OnClickListener {

    private Button btnRegister;
    private EditText editUsername;
    private EditText editPassword;
    private EditText editName;
    private EditText editLocation;
    private EditText editPhone;
    private EditText editGender;
    private EditText editBlood;
    private EditText editRhesus;

    private final ApiService service = new ApiService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.register_fragment, container, false);

        btnRegister = view.findViewById(R.id.btn_register);
        editUsername = view.findViewById(R.id.edit_username_register);
        editPassword = view.findViewById(R.id.edit_pass_register);
        editName = view.findViewById(R.id.edit_name_register);
        editLocation = view.findViewById(R.id.edit_location_register);
        editPhone = view.findViewById(R.id.edit_phone_register);
        editGender = view.findViewById(R.id.edit_gender_register);
        editBlood = view.findViewById(R.id.edit_blood_register);
        editRhesus = view.findViewById(R.id.edit_rhesus_register);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnRegister.setOnClickListener(this);
    }

    private void register() {
        Call<UserResponse> userCall = service.getService().register(
            String.valueOf(editUsername.getText()),
            String.valueOf(editPassword.getText()),
            String.valueOf(editName.getText()),
            String.valueOf(editBlood.getText()),
            String.valueOf(editRhesus.getText()),
            String.valueOf(editLocation.getText()),
            String.valueOf(editPhone.getText()),
            String.valueOf(editGender.getText()),
            "NO"
        );
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register) {
            register();
        }
    }
}
