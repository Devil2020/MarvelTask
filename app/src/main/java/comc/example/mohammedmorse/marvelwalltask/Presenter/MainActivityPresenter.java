package comc.example.mohammedmorse.marvelwalltask.Presenter;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.Model.Network;
import comc.example.mohammedmorse.marvelwalltask.Model.Post;
import comc.example.mohammedmorse.marvelwalltask.Model.Retrofit.CustomRetrofit;
import comc.example.mohammedmorse.marvelwalltask.View.MainActivityView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public class MainActivityPresenter implements Presenter{
     CustomRetrofit retrofit;
        Network network;
     MainActivityView view;
     Context context;
     public MainActivityPresenter(MainActivityView view, Context context){
         this.view=view;
         this.context=context;
     }

    @Override
    public void CheckNetwork() {
          network=new Network(context);
         boolean x= network.IsConnected();
         view.ifNetwork(x);
    }

    @Override
    public void onCreate() {
        retrofit=CustomRetrofit.getInstance();
        retrofit.InitRetrofit("https://jsonplaceholder.typicode.com");
        Observable<ArrayList<Post>> observable=retrofit.MakeaCall();
        Observer<ArrayList<Post>> observer=new Observer<ArrayList<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("Morse", "onSubscribe: Done ");
            }

            @Override
            public void onNext(ArrayList<Post> posts) {
                 view.SetAdapterData(posts);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }                                   ;
        observable.observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.newThread()).
                subscribe(observer);

    }
}
