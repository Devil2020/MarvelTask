package comc.example.mohammedmorse.marvelwalltask.Model.Retrofit;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.Model.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public interface CustomRetrofitOperations {
    @GET("posts")
    public Observable<ArrayList<Post>> getData();
}
