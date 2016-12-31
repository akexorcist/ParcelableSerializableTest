package com.akexorcist.myscratch2;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private float totalCount = 10000;
    private Button btnParcelable;
    private Button btnSerializable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnParcelable = (Button) findViewById(R.id.btn_parcelable);
        btnParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long totalTimeUsage = 0;
                for (int i = 0; i < totalCount; i++) {
                    long startTime = System.nanoTime();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("Post", createPostParcelable());
                    bundle.writeToParcel(Parcel.obtain(), 0);
                    PostParcelable post = bundle.getParcelable("Post");
                    long endTime = System.nanoTime();
                    totalTimeUsage += endTime - startTime;
                }
                Log.e("Check", "Average Time Usage : " + (totalTimeUsage / totalCount));
            }
        });

        btnSerializable = (Button) findViewById(R.id.btn_serializable);
        btnSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long totalTimeUsage = 0;
                for (int i = 0; i < totalCount; i++) {
                    long startTime = System.nanoTime();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Post", createPostSerializable());
                    bundle.writeToParcel(Parcel.obtain(), 0);
                    PostSerializable post = (PostSerializable) bundle.getSerializable("Post");
                    long endTime = System.nanoTime();
                    totalTimeUsage += endTime - startTime;
                }
                Log.e("Check", "Average Time Usage : " + (totalTimeUsage / totalCount));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private PostParcelable createPostParcelable() {
        PostParcelable postParcelable = new PostParcelable();
        postParcelable.setTitle("Title");
        postParcelable.setContent("Content");
        postParcelable.setId("75681203");
        postParcelable.setDate("01/01/2017");
        postParcelable.setUrl("Url");
        postParcelable.setAuthor("Author");
        postParcelable.setReadCount(7510);
        postParcelable.setDraft(false);
        postParcelable.setTagist(Arrays.asList("Tag 1", "Tag 2", "Tag 3"));
        postParcelable.setCommentList(Arrays.asList(
                createCommentParcelable("User 1", "Text 1", "01/01/2017"),
                createCommentParcelable("User 2", "Text 2", "01/01/2017"),
                createCommentParcelable("User 3", "Text 3", "01/01/2017")
        ));
        return postParcelable;
    }

    private PostParcelable.Comment createCommentParcelable(String user, String text, String date) {
        PostParcelable.Comment comment = new PostParcelable.Comment();
        comment.setUser(user);
        comment.setComment(text);
        comment.setDate(date);
        return comment;
    }

    private PostSerializable createPostSerializable() {
        PostSerializable postSerializable = new PostSerializable();
        postSerializable.setTitle("Title");
        postSerializable.setContent("Content");
        postSerializable.setId("75681203");
        postSerializable.setDate("01/01/2017");
        postSerializable.setUrl("Url");
        postSerializable.setAuthor("Author");
        postSerializable.setReadCount(7510);
        postSerializable.setDraft(false);
        postSerializable.setTagist(Arrays.asList("Tag 1", "Tag 2", "Tag 3"));
        postSerializable.setCommentList(Arrays.asList(
                createCommentSerializable("User 1", "Text 1", "01/01/2017"),
                createCommentSerializable("User 2", "Text 2", "01/01/2017"),
                createCommentSerializable("User 3", "Text 3", "01/01/2017")
        ));
        return postSerializable;
    }

    private PostSerializable.Comment createCommentSerializable(String user, String text, String date) {
        PostSerializable.Comment comment = new PostSerializable.Comment();
        comment.setUser(user);
        comment.setComment(text);
        comment.setDate(date);
        return comment;
    }
}
