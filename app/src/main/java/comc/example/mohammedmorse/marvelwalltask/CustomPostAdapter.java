package comc.example.mohammedmorse.marvelwalltask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.Model.Post;
import comc.example.mohammedmorse.marvelwalltask.View.MainActivityView;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public class CustomPostAdapter extends RecyclerView.Adapter<CustomPostAdapter.CustomPostHolder> {
    Context context;
    ArrayList<Post> posts;
    MainActivityView views;
    public CustomPostAdapter(Context context , ArrayList<Post> posts,MainActivityView view){
        this.context=context;
        this.posts=posts;
        this.views=view;
    }
    @NonNull
    @Override
    public CustomPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerviewitem,parent,false);
        CustomPostHolder holder=new CustomPostHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomPostHolder holder, final int position) {
         holder.UserId.setText(String .valueOf(posts.get(position).getUserId()));
        holder.Id.setText(String.valueOf(posts.get(position).getId()));
        holder.Title.setText(posts.get(position).getTitle());
        holder.Body.setText(posts.get(position).getBody());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                views.onClick(posts.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class CustomPostHolder extends RecyclerView.ViewHolder{
       TextView UserId,Id,Title,Body;
       LinearLayout layout;
        public CustomPostHolder(View itemView) {
            super(itemView);
            UserId=itemView.findViewById(R.id.UserId);
            Id=itemView.findViewById(R.id.Id);
            Title =itemView.findViewById(R.id.Title);
            Body=itemView.findViewById(R.id.Body);
            layout=itemView.findViewById(R.id.ItemLayout);
        }
    }
}
