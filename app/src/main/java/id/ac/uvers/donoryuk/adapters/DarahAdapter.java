package id.ac.uvers.donoryuk.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.uvers.donoryuk.R;
import id.ac.uvers.donoryuk.models.User;

public class DarahAdapter extends RecyclerView.Adapter<DarahAdapter.DarahViewHolder>{

    private ArrayList<User> users = new ArrayList<>();

    @NonNull
    @Override
    public DarahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DarahViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DarahAdapter.DarahViewHolder holder, int position) {
        holder.bindItem(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(ArrayList<User> fetched) {
        users.clear();
        users.addAll(fetched);
        Log.d("BANGSAT", fetched.get(0).getName());
        notifyDataSetChanged();
    }

    static class DarahViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textLocation, textBlood;
        DarahViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name_holder);
            textLocation = itemView.findViewById(R.id.text_location_holder);
            textBlood = itemView.findViewById(R.id.text_blood_holder);
        }

        @SuppressLint("SetTextI18n")
        void bindItem(final User user) {
            textName.setText(user.getName());
            textLocation.setText(user.getLocation());
            textBlood.setText(user.getBlood() + user.getRhesus());
        }
    }
}
