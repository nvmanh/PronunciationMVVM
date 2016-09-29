package bluetapestudio.pronunciationmvvm.vn.model;

import android.databinding.ObservableField;

import retrofit2.http.POST;
import rx.Observable;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 27/09/2016.
 */

public interface InterviewApiService {
    public static final String BASE_URL = "http://192.168.5.110/interview/index.php/api/";
    public static final String GET_QUESTION = "apiQuestionControl/questions";
    public static final String REGISTER_USER = "apiUser/register";
    public static final String LOGIN_USER = "apiUser/login";

    @GET(GET_QUESTION)
    Observable<List<Question>> fetchAllQuestions();

    @GET(GET_QUESTION)
    Observable<Question> fetchQuestion(@Query("id") int id);

    @POST(REGISTER_USER)
    Observable<User> register(@Query("userName") String userName, @Query("password")
            String password, @Query("email") String email, @Query("phone") String phone);

    @POST(LOGIN_USER)
    Observable<User> login(@Query("userName") String userName, @Query("password") String password);

    class InterviewFactory {
        public static InterviewApiService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(InterviewApiService.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(InterviewApiService.class);
        }
    }
}
