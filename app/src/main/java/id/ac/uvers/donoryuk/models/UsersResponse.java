package id.ac.uvers.donoryuk.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersResponse {
    @SerializedName("status")
    private String success;

    @SerializedName("data")
    private ArrayList<User> users;

    public String isSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
