package comc.example.mohammedmorse.marvelwalltask.Model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public class Network {
    Context context;
    public Network(Context context){
        this.context=context;
    }
    public boolean IsConnected(){
        ConnectivityManager compat= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=compat.getActiveNetworkInfo();
        return info!=null&&info.isConnected();
    }
}
