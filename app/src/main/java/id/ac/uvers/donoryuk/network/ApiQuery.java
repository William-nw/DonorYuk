package id.ac.uvers.donoryuk.network;

import id.ac.uvers.donoryuk.models.UserResponse;
import id.ac.uvers.donoryuk.models.UsersResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiQuery {

    @GET("WFSJoEPUTcI4WkX7x39OkUZ7sZSpzlTQ/fetch-user")
    Call<UsersResponse> fetch();

    @FormUrlEncoded
    @POST("WFSJoEPUTcI4WkX7x39OkUZ7sZSpzlTQ/insert-user")
    Call<UserResponse> register(
        @Field("username") String username,
        @Field("password") String password,
        @Field("nama") String name,
        @Field("golongan_darah") String blood,
        @Field("rhesus") String rhesus,
        @Field("lokasi") String location,
        @Field("no_hp") String phone,
        @Field("gender") String gender,
        @Field("status_donor") String status
    );

    @FormUrlEncoded
    @POST("WFSJoEPUTcI4WkX7x39OkUZ7sZSpzlTQ/user")
    Call<UserResponse> login(
        @Field("username") String username,
        @Field("password") String password
    );

    @FormUrlEncoded
    @POST("WFSJoEPUTcI4WkX7x39OkUZ7sZSpzlTQ/update-user")
    Call<UserResponse> update(
            @Field("id") int id,
            @Field("nama") String name,
            @Field("golongan_darah") String blood,
            @Field("rhesus") String rhesus,
            @Field("lokasi") String location,
            @Field("no_hp") String phone,
            @Field("gender") String gender,
            @Field("status_donor") String status
    );
}
