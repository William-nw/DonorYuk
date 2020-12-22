package id.ac.uvers.donoryuk.models;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("status")
    private String success;

    @SerializedName("data")
    private User user;

    public String isSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
