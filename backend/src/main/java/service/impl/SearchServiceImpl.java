package service.impl;

import model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import service.SearchService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Content> searchAct(String search) {

        //输入字符串判空
        if (search == null || search.isBlank()) {
            return Collections.emptyList();
        }

        //正则表达式与模糊查询组合，目前ai code，后期学习
        String keyword = Pattern.quote(search);
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);

        Query queryTitle = Query.query(Criteria.where("title").regex(pattern));
        List<Content> contentList = mongoTemplate.find(queryTitle, Content.class);


        //如果title查不到就直接查找text
        if (contentList.size() == 0) {
            Query query = Query.query(Criteria.where("contentText").regex(pattern));
            List<Content> contentList2 = mongoTemplate.find(query, Content.class);
            if (contentList2.size() == 0) {
                //如果返回null，上层代码不做判空处理会报错
                return Collections.emptyList();
            }
            return contentList2;
        }

        //避免text中查询内容与title中重复
        List<String> hitIds = new ArrayList<>();
        for (Content content : contentList) {
            String id = content.getId();
            hitIds.add(id);
        }

        Query queryText = Query.query(Criteria
                .where("contentText").regex(pattern)
                //monogodb数据id为_id
                .and("_id").nin(hitIds));
        List<Content> contents = mongoTemplate.find(queryText, Content.class);
        //使查询数据title中含有关键词优先渲染
        contentList.addAll(contents);



        return contentList;
    }
}
