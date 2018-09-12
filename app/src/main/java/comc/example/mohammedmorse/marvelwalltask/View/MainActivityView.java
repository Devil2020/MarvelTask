package comc.example.mohammedmorse.marvelwalltask.View;

import java.util.ArrayList;

import comc.example.mohammedmorse.marvelwalltask.Model.Post;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public interface MainActivityView {
    public void SetAdapterData(ArrayList<Post> posts);
    public void onClick(Post post);
    public void ifNetwork(boolean x);
    public void ShowLoadingDialog();
    public void ShowAlertDialog();
}
