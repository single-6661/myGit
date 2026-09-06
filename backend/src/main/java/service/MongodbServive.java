package service;

//插入用户，帖子，评论数据，仅执行一次
public interface MongodbServive {

    public void insertContent();

    public void insertHot();

    public void insertUser();

}
