package comc.example.mohammedmorse.marvelwalltask.Model.Retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.Model.Post;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public class CustomRetrofit {
    private static volatile CustomRetrofit retrofit;
    private Retrofit Custretrofit;
    private CustomRetrofit(){
        if(retrofit!=null){
        throw new RuntimeException("You Can`t make from it another Object");
    }
                        }
    public synchronized static CustomRetrofit getInstance(){
               if(retrofit==null){
                   retrofit=new CustomRetrofit();
               }
        return retrofit;
    }
    public void InitRetrofit(String Url){
       Custretrofit=new Retrofit.Builder().baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public Observable<ArrayList<Post>> MakeaCall(){
        CustomRetrofitOperations helper=Custretrofit.create(CustomRetrofitOperations.class);
        Observable<ArrayList<Post>> call=helper.getData();
        return call;
    }
}
