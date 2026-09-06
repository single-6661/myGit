package service.impl;

import model.Content;
import model.Hot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import service.GetDataService;

import java.util.ArrayList;
import java.util.List;

@Service
public class getDataServiceImpl implements GetDataService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Content> getContent() {
        List<Content> contents = mongoTemplate.findAll(Content.class);

        return contents;
    }

    @Override
    public List<Hot> getHot() {
        List<Hot> hots = mongoTemplate.findAll(Hot.class);

        return hots;
    }

}
