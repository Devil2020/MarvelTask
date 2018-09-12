package comc.example.mohammedmorse.marvelwalltask.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.CustomPostAdapter;
import comc.example.mohammedmorse.marvelwalltask.Model.Post;
import comc.example.mohammedmorse.marvelwalltask.Presenter.MainActivityPresenter;
import comc.example.mohammedmorse.marvelwalltask.Presenter.Presenter;
import comc.example.mohammedmorse.marvelwalltask.R;
import comc.example.mohammedmorse.marvelwalltask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainActivityView{
       ActivityMainBinding binding;
       Presenter presenter;
       CustomPostAdapter adapter;
       RecyclerView.LayoutManager manager;
       DialogFragment dialogFragment;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Task");
        manager=new LinearLayoutManager(this);
        presenter=new MainActivityPresenter(this,MainActivity.this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter.CheckNetwork();
    }

    @Override
    public void SetAdapterData(ArrayList<Post> posts) {
           dialogFragment.dismiss();
        adapter=new CustomPostAdapter(this,posts,this);
        binding.CustomRecyclerView.setAdapter(adapter);
        binding.CustomRecyclerView.setLayoutManager(manager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        binding.CustomRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onClick(Post post) {
        Toast.makeText(this, "UserId: "+post.getUserId()+" , Id: "+post.getId()
                +" , Title: "+post.getTitle()+" , Body:"+post.getBody(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ifNetwork(boolean x) {
        if(x==false){
            ShowAlertDialog();
        }
        else{
           // Nothing
            presenter.onCreate();
            ShowLoadingDialog();
        }
        Log.i("Morse", "ifNetwork: "+x);
    }

    @Override
    public void ShowLoadingDialog() {
        dialogFragment=new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"Loading");
    }

    @Override
    public void ShowAlertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this).
                setTitle("Network Error").setMessage("Please Check your Network Connection , Open your WIFI or Open your Data .")
                .setIcon(R.drawable.ic_network_wifi_black_24dp).setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        dialog.show();
    }
}
