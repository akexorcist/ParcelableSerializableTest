package com.akexorcist.myscratch2;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Akexorcist on 12/31/2016 AD.
 */

public class PostSerializable implements Serializable {
    private String title;
    private String content;
    private String id;
    private String date;
    private String author;
    private String url;
    private int readCount;
    private boolean isDraft;
    private List<String> tagist;
    private List<Comment> commentList;

    public PostSerializable() {
    }

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

    public static class Comment implements Serializable {
        private String comment;
        private String user;
        private String date;

        public Comment() {
        }

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
    }
}
