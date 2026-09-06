package service.impl;

import model.Content;
import model.Hot;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import service.DataInsertService;
import service.MongodbServive;

import java.util.List;

@Service
public class MongodbServiceImpl implements MongodbServive {

    @Autowired
    private DataInsertService dataInsertService;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insertContent() {
        List<Content>  contents = dataInsertService.getApiContent();
        mongoTemplate.insert(contents,Content.class);
    }

    @Override
    public void insertHot() {
        List<Hot> hots = dataInsertService.getApiHot();
        mongoTemplate.insert(hots,Hot.class);
    }

    @Override
    public void insertUser() {

        User user = new User();
        user.setUsername("大葱");
        user.setPassword("123456");
        user.setMobile("88888888");
        mongoTemplate.insert(user);
    }
}
