package com.akexorcist.myscratch2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PostParcelable implements Parcelable{
    private String title;
    private String content;
    private String id;
    private String date;
    private String author;
    private String url;
    int readCount;
    boolean isDraft;
    List<String> tagist;
    List<Comment> commentList;

    public PostParcelable() {
    }

    protected PostParcelable(Parcel in) {
        title = in.readString();
        content = in.readString();
        id = in.readString();
        date = in.readString();
        author = in.readString();
        url = in.readString();
        readCount = in.readInt();
        isDraft = in.readByte() != 0;
        tagist = in.createStringArrayList();
        commentList = in.createTypedArrayList(Comment.CREATOR);
    }

    public static final Creator<PostParcelable> CREATOR = new Creator<PostParcelable>() {
        @Override
        public PostParcelable createFromParcel(Parcel in) {
            return new PostParcelable(in);
        }

        @Override
        public PostParcelable[] newArray(int size) {
            return new PostParcelable[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public List<String> getTagist() {
        return tagist;
    }

    public void setTagist(List<String> tagist) {
        this.tagist = tagist;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(id);
        parcel.writeString(date);
        parcel.writeString(author);
        parcel.writeString(url);
        parcel.writeInt(readCount);
        parcel.writeByte((byte) (isDraft ? 1 : 0));
        parcel.writeStringList(tagist);
        parcel.writeTypedList(commentList);
    }

    public static class Comment implements Parcelable{
        private String comment;
        private String user;
        private String date;

        public Comment() {
        }

        protected Comment(Parcel in) {
            comment = in.readString();
            user = in.readString();
            date = in.readString();
        }

        public static final Creator<Comment> CREATOR = new Creator<Comment>() {
            @Override
            public Comment createFromParcel(Parcel in) {
                return new Comment(in);
            }

            @Override
            public Comment[] newArray(int size) {
                return new Comment[size];
            }
        };

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(comment);
            parcel.writeString(user);
            parcel.writeString(date);
        }
    }
}
