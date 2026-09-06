package model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="content")
public class Content {

    private String authorName;
    private String authorAvatar;
    private String title;
    private String contentText;
    private String commentCount;
    private String[] commentInfolist;
    private String voteUpCount;
    private String date;
    private String id;

    public String getVoteUpCount() {
        return voteUpCount;
    }

    public void setVoteUpCount(String voteUpCount) {
        this.voteUpCount = voteUpCount;
    }

    public String[] getCommentInfolist() {
        return commentInfolist;
    }

    public void setCommentInfolist(String[] commentInfolist) {
        this.commentInfolist = commentInfolist;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
