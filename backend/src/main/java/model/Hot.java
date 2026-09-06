package model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hot")
//为类设置集合名
public class Hot {
    private String hot;
    private String id;

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
