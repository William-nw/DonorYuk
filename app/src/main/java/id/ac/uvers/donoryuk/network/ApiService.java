package id.ac.uvers.donoryuk.network;

import java.io.IOException;

import id.ac.uvers.donoryuk.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private ApiQuery query;

    public ApiService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url()
                                .newBuilder()
                                .build();

                        original = original.newBuilder()
                                .url(httpUrl)
                                .build();

                        return chain.proceed(original);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        query = retrofit.create(ApiQuery.class);
    }

    public ApiQuery getService() {
        return query;
    }
}
