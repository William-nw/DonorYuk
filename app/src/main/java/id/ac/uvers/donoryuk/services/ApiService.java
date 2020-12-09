package id.ac.uvers.donoryuk.services;

import android.content.Context;

public class ApiService {

    private static ApiService instance;
    private Context context;

    public static void shared(Context context) {
        if (instance == null) {
            instance = new ApiService(context);
        }
    }

    private ApiService(Context context) {
        this.context = context;
    }

}
