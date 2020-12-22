package id.ac.uvers.donoryuk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import id.ac.uvers.donoryuk.models.User;
import id.ac.uvers.donoryuk.models.UserResponse;
import id.ac.uvers.donoryuk.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dataDiri extends Fragment implements View.OnClickListener {

    private ApiService service = new ApiService();
    private Button btnNeed;

    private TextView textName, textGender, textLocation, textBlood, textPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_diri, container, false);
        btnNeed = view.findViewById(R.id.btn_need);
        textName = view.findViewById(R.id.textView7);
        textGender = view.findViewById(R.id.textView13);
        textBlood = view.findViewById(R.id.textView14);
        textLocation = view.findViewById(R.id.textView15);
        textPhone = view.findViewById(R.id.textView16);
        btnNeed.setOnClickListener(this);
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SessionPreference session = new SessionPreference(Objects.requireNonNull(getContext()));
        User user = session.getUser();

        setButton();

        textName.setText(user.getName());
        textGender.setText(user.getGender());
        textBlood.setText(user.getBlood());
        textLocation.setText(user.getLocation());
        textPhone.setText(user.getPhone());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_need) {
            update();
        }
    }

    private void update() {
        SessionPreference session = new SessionPreference(Objects.requireNonNull(getContext()));
        User user = session.getUser();
        Log.d("BANGSAT", user.getName());
        Call<UserResponse> userCall = service.getService().update(
                user.getId(),
                user.getName(),
                user.getBlood(),
                user.getRhesus(),
                user.getLocation(),
                user.getPhone(),
                user.getGender(),
                user.getStatus().equals("YES") ? "NO" : "YES"
        );
        User newUser = new User();
        newUser.setStatus(user.getStatus().equals("YES") ? "NO" : "YES");
        session.setUser(newUser);
        userCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    setButton();
                    Intent intent = new Intent(getContext(), ReqDarahActivity.class);
                    Objects.requireNonNull(getContext()).startActivity(intent);
                } else {
                    Log.d("data", "gagal update");
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                Log.d("data", "gagal");
            }
        });
    }

    private void setButton() {
        SessionPreference session = new SessionPreference(Objects.requireNonNull(getContext()));
        if (session.getUser().getStatus().equals("YES")) {
            btnNeed.setText("Sedang Butuh");
        } else {
            btnNeed.setText("Butuh Bantuan");
        }
    }
}