package comc.example.mohammedmorse.marvelwalltask.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohammed Morse on 12/09/2018.
 */

public class Post {
    @SerializedName("userId")
    private int UserId;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    @SerializedName("id")
    private int Id;
    @SerializedName("title")
    private String Title;
    @SerializedName("body")
    private String Body;

}
